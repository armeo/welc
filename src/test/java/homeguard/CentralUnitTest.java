package homeguard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CentralUnitTest {

    public static void assertSensorMessage(String type, String nonTrippedMessage, String trippedMessage){
        {
            CentralUnit centralUnit = new CentralUnit();
            Sensor sensor = new Sensor("1", "<X>", type);
            assertThat(centralUnit.getSensorMessage(sensor), is(nonTrippedMessage));
        }
        {
            CentralUnit centralUnit = new CentralUnit();
            Sensor sensor = new Sensor("1", "<X>", type);
            sensor.trip();
            assertThat(centralUnit.getSensorMessage(sensor), is(trippedMessage));
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