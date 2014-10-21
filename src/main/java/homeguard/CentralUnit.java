package homeguard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CentralUnit {
    private boolean armed = false;
    private String securityCode;
    private List sensors = new LinkedList();
    private HomeGuardView view = new TextView();
    private AudibleAlarm audibleAlarm = new TextAudibleAlarm();

    Diagnostics diagnostics = new Diagnostics();

    public boolean isArmed() {
        return armed;
    }

    public void arm() {
        armed = true;
    }

    public void setSecurityCode(String code) {
        securityCode = code;
    }

    public boolean isValidCode(String code) {
        return securityCode.equals(code);
    }

    public void enterCode(String code) {
        if (isValidCode(code)) {
            armed = false;
            audibleAlarm.silence();
        }
    }

    public boolean audibleAlarmIsOn() {
        return false;
    }

    public List getSensors() {
        return sensors;
    }

    public void registerSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public void setView(HomeGuardView view) {
        this.view = view;
    }

    public void setAudibleAlarm(AudibleAlarm alarm) {
        audibleAlarm = alarm;
    }

    public void parseRadioBroadcast(String packet) {
        Packet packetSensor = new Packet(packet);

        Sensor sensor = getSensorById(packetSensor.getSensorId());

        if(sensor == null)
            return;

        if ("TRIPPED".equals(packetSensor.getSensorStatus()))
            sensor.trip();
        else
            sensor.reset();

        showMessage(sensor);

        if (isArmed())
            audibleAlarm.sound();

        diagnostics.update(packetSensor);
    }

    private void showMessage(Sensor sensor) {
        view.showMessage(sensor.getMessage());
    }

    private Sensor getSensorById(String id) {
        for (Iterator iterator = sensors.iterator(); iterator.hasNext(); ) {
            Sensor s = (Sensor) iterator.next();
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void runSensorTest() {
        diagnostics.run(sensors);
    }
}