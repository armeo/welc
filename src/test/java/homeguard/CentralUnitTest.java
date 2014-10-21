package homeguard;

import org.junit.Test;

public class CentralUnitTest {

    @Test
    public void shouldCompleteParseRadioWhenSensorNotFound(){
        CentralUnit unit = new CentralUnit();
        String packet = "1, reset";
        unit.parseRadioBroadcast(packet);
    }

    @Test
    public void shouldCallParseRadioBroadcast(){
        CentralUnit unit = new CentralUnit();
        unit.registerSensor(new DoorSensor("1", "Door", Sensor.DOOR));

        unit.setView(new FakeView());
        unit.setAudibleAlarm(new FakeAlam());

        String packet = "1, reset";

        unit.parseRadioBroadcast(packet);
    }
}

class FakeView implements HomeGuardView{

    @Override
    public void showMessage(String message) {

    }
}

class FakeAlam implements AudibleAlarm{

    @Override
    public void sound() {

    }

    @Override
    public void silence() {

    }
}