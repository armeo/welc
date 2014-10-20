package scheduler;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchedulerTest {

    @Test
    public void testCreate(){
        Date now = new Date();
        new TestingScheduler("Bill", new FakeDisplay()).addEvent(new Event(now, DayTime.Time10AM));
    }

    @Test
    public void shouldReturnsMeetingWhenNotHoliday(){
        Date now = new Date();
        Scheduler scheduler = new TestingScheduler("Bill", new FakeDisplay());
        scheduler.addEvent(new Meeting(now, DayTime.Time10AM, "meeting"));
        assertThat(scheduler.getMeeting(now, DayTime.Time10AM, new NotHolidayTimeService()).getText(), is("meeting"));
    }

    @Test
    public void shouldNotReturnsMeetingWhenHoliday(){
        Date now = new Date();
        Scheduler scheduler = new TestingScheduler("Bill", new FakeDisplay());
        scheduler.addEvent(new Meeting(now, DayTime.Time10AM, "meeting"));
        assertThat(scheduler.getMeeting(now, DayTime.Time10AM, new HolidayTimeService()), is(nullValue()));
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

class NotHolidayTimeService extends TimeServices{
    public boolean isDateAHoliday(Date date) {
        return false;
    }
}

class HolidayTimeService extends TimeServices{
    public boolean isDateAHoliday(Date date) {
        return true;
    }
}