package homeguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Diagnostics {
    public Map sensorTestStatusMap;
    public boolean runningSensorTest;
    public String sensorTestStatus;

    public void terminate() {
        runningSensorTest = false;

        // look at individual sensor status to determine the overall test status
        sensorTestStatus = determinateSensorTestStatus();
    }

    void update(Packet packet) {
        if (runningSensorTest) {
            if ("TRIPPED".equals(packet.getSensorStatus())) {
                sensorTestStatusMap.put(packet.getSensorId(), SensorStatus.PASS);
            }

            //terminate test if complete
            if (isSensorTestComplete())
                terminate();
        }
    }

    public void run(List sensors) {
        runningSensorTest = true;
        sensorTestStatus = SensorStatus.PENDING;

        // initialize the status map
        sensorTestStatusMap = new HashMap();
        for (Iterator iterator = sensors.iterator(); iterator.hasNext(); ) {
            Sensor sensor = (Sensor) iterator.next();
            sensorTestStatusMap.put(sensor.getId(), SensorStatus.PENDING);
        }
    }

    private String determinateSensorTestStatus() {
        for (Iterator iterator = sensorTestStatusMap.values().iterator(); iterator.hasNext(); ) {
            String status = (String) iterator.next();
            if (status.equals(SensorStatus.PENDING)) {
                return SensorStatus.FAIL;
            }
        }

        return SensorStatus.PASS;
    }

    private boolean isSensorTestComplete() {
        for (Iterator iterator = sensorTestStatusMap.values().iterator(); iterator.hasNext(); ) {
            String testStatus = (String) iterator.next();
            if (SensorStatus.PENDING.equals(testStatus)) {
                return false;
            }
        }
        return true;
    }
}
