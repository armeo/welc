package scheduler;

import org.junit.Test;

import java.util.Date;

public class SchedulerTest {

    @Test
    public void testCreate(){
        Date now = new Date();
        new Scheduler("Bill").addEvent(new Event(now, DayTime.Time10AM));
    }
}
