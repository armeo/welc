package scheduler;

import org.junit.Test;

import java.util.Date;

public class SchedulerTest {

    @Test
    public void testCreate(){
        Date now = new Date();
        new TestingScheduler("Bill", new FakeDisplay()).addEvent(new Event(now, DayTime.Time10AM));
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