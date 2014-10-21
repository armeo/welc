package homeguard;

public class MotionSensor extends Sensor {

    public MotionSensor(String id, String location, String type) {
        super(id, location, type);
    }

    @Override
    protected String nonTrippedMessage() {
        return getLocation() + " is motionless";
    }

    @Override
    protected String trippedMessage() {
        return "Motion detected in " + getLocation();
    }

    public String getType() {
        return MOTION;
    }
}
