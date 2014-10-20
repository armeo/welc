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

    // members to help with sensor tests
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
        //parse the packet
        String[] tokens = packet.split(",");
        String id = tokens[0];
        String status = tokens[1];

        // find sensor with id
        Sensor sensor = getSensorById(id);

        //trip or reset sensor
        tripOrResetSensor(status, sensor);

        //get the message from the sensor and display it
        view.showMessage(sensor.getMessage());

        // sound the alarm if armed
        if (isArmed()) audibleAlarm.sound();

        // check if a sensor test is running and adjust status
        diagnostics.update(id, status);
    }

    private void tripOrResetSensor(String status, Sensor sensor) {
        if (sensor != null) {
            if ("TRIPPED".equals(status)) sensor.trip();
            else sensor.reset();
        }
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