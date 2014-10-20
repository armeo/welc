package homeguard;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CentralUnitTest {
    private CentralUnit centralUnit;

    @Before
    public void setUp(){
        centralUnit = new CentralUnit();
    }

    @Test
    public void shouldReturnLocationIsOpenWhenIsTrippedAndDoor(){
        Sensor sensor = new Sensor("0", "Home", Sensor.DOOR);
        sensor.trip();

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is open"));
    }

    @Test
    public void shouldReturnLocationIsAjarWhenIsTrippedAndWindow(){
        Sensor sensor = new Sensor("0", "Home", Sensor.WINDOW);
        sensor.trip();

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is ajar"));
    }

    @Test
    public void shouldReturnMotionDetectedInLocationWhenIsTrippedAndMotion(){
        Sensor sensor = new Sensor("0", "Home", Sensor.MOTION);
        sensor.trip();

        assertThat(centralUnit.getSensorMessage(sensor), is("Motion detected in Home"));
    }

    @Test
    public void shouldReturnLocationInOnFireWhenIsTrippedAndFire(){
        Sensor sensor = new Sensor("0", "Home", Sensor.FIRE);
        sensor.trip();

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is on FIRE!"));
    }

    @Test
    public void shouldReturnLocationIsClosedWhenIsNotTrippedAndDoor(){
        Sensor sensor = new Sensor("0", "Home", Sensor.DOOR);

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is closed"));
    }

    @Test
    public void shouldReturnLocationIsSealedWhenIsNotTrippedAndWindow(){
        Sensor sensor = new Sensor("0", "Home", Sensor.WINDOW);

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is sealed"));
    }

    @Test
    public void shouldReturnLocationIsMotionlessWhenIsNotTrippedAndMotion(){
        Sensor sensor = new Sensor("0", "Home", Sensor.MOTION);

        assertThat(centralUnit.getSensorMessage(sensor), is("Home is motionless"));
    }

    @Test
    public void shouldReturnLocationTemperatureInNormalWhenIsNotTrippedAndFire(){
        Sensor sensor = new Sensor("0", "Home", Sensor.FIRE);

        assertThat(centralUnit.getSensorMessage(sensor), is("Home temperature is normal"));
    }

    @Test
    public void shouldReturnDefaultMessageWhenSensorIsNotInitial(){
        Sensor sensor = new Sensor("", "", "");

        assertThat(centralUnit.getSensorMessage(sensor), is("default"));
    }
}