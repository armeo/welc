package homeguard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SensorTest {

    public static Sensor makeSensor(String id, String location, String type){
        if(Sensor.DOOR.equals(type))
            return new DoorSensor(id, location, type);
        else if(Sensor.WINDOW.equals(type))
            return new WindowSensor(id, location, type);
        else if(Sensor.MOTION.equals(type))
            return new MotionSensor(id, location, type);
        else if(Sensor.FIRE.equals(type))
            return new FireSensor(id, location, type);
      return new Sensor(id, location, type);
    }

    public static void assertSensorMessage(String type, String nonTrippedMessage, String trippedMessage){
        {
            Sensor sensor = makeSensor("1", "<X>", type);
            assertThat(sensor.getMessage(), is(nonTrippedMessage));
        }
        {
            Sensor sensor = makeSensor("1", "<X>", type);
            sensor.trip();
            assertThat(sensor.getMessage(), is(trippedMessage));
        }
    }

    @Test
    public void testSensorMessages(){
        assertSensorMessage(Sensor.DOOR, "<X> is closed", "<X> is open");
        assertSensorMessage(Sensor.WINDOW, "<X> is sealed", "<X> is ajar");
        assertSensorMessage(Sensor.MOTION, "<X> is motionless", "Motion detected in <X>");
        assertSensorMessage(Sensor.FIRE, "<X> temperature is normal", "<X> is on FIRE!");
        assertSensorMessage("", "default", "default");
    }
}
