package homeguard;

public class MotionSensor extends Sensor {

    public MotionSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType() {
        return MOTION;
    }

    public String getMessage() {
        return isTripped() ? "Motion detected in " + getLocation() : getLocation() + " is motionless";
    }
}
