package homeguard;

public class MotionSensor extends Sensor {

    public MotionSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType() {
        return MOTION;
    }

    public String getMessage() {
        if (!isTripped()) return getLocation() + " is motionless";
        return "Motion detected in " + getLocation();
    }
}
