package scheduler;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchedulerTest {

    @Test
    public void testCreate(){
        Date now = new Date();
        new TestingScheduler("Bill", new FakeDisplay()).addEvent(new Event(now, DayTime.Time10AM));
    }

    @Test
    public void sholdReturnsMeetingWhenNotHoliday(){
        Date now = new Date();
        Scheduler scheduler = new TestingScheduler("Bill", new FakeDisplay());
        scheduler.addEvent(new Meeting(now, DayTime.Time10AM, "meeting"));
        assertThat(scheduler.getMeeting(now, DayTime.Time10AM, new FakeTimeService()).getText(), is("meeting"));
    }
}

class FakeDisplay implements Display {

    public void showEvent(Event event) {

    }
}

class TestingScheduler extends Scheduler{
    public TestingScheduler(String owner, Display display){
        super(owner, display);
    }

    protected void sendMail(String address, String subject, String message){
    }
}

class FakeTimeService extends TimeServices{
    public boolean isDateAHoliday(Date date) {
        return false;
    }
}