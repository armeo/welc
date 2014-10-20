package scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Scheduler {
    private String owner = "";
    private MailService mailService;
    private Display display;
    private List events = new ArrayList();

    public Scheduler(String owner) {
        this(owner, new SchedulerDisplay());
    }

    public Scheduler(String owner, Display display) {
        this.owner = owner;

        mailService = MailService.getInstance();
        this.display = display;
    }

    public void addEvent(Event event) {
        event.added();
        events.add(event);
        sendMail("jacques@spg1.com", "Event Notification", event.toString());
        display.showEvent(event);
    }

    protected void sendMail(String address, String subject, String message) {
        mailService.sendMail(address, subject, message);
    }

    public boolean hasEvents(Date date) {
        for (Iterator it = events.iterator(); it.hasNext(); ) {
            Event event = (Event) it.next();
            if (event.getDate().equals(date)) return true;
        }
        return false;
    }

    public void performConsistencyCheck(StringBuffer message) {

    }

    public void update() {
        for (Iterator it = events.iterator(); it.hasNext(); ) {
            Event event = (Event) it.next();

            if (!(event instanceof Meeting)) {
                continue;
            }

            Meeting meeting = (Meeting) event;

            String note = NoteRetriever.get_note(meeting.getDate());
            if (note.length() == 0) continue;

            meeting.appendToText(note);
        }
    }

    public Meeting getMeeting(Date date, int slot) {
        return getMeeting(date, slot, new TimeServices());
    }

    public Meeting getMeeting(Date date, int slot, TimeServices timeServices) {
        for (Iterator it = events.iterator(); it.hasNext(); ) {
            Event event = (Event) it.next();
            if (!(event instanceof Meeting)) continue;
            Meeting meeting = (Meeting) event;
            if (meeting.getDate().equals(date) && meeting.getSlot() == slot && !timeServices.isDateAHoliday(meeting.getDate()))
                return meeting;

        }
        return null;
    }
}