package homeguard;

public class DoorSensor extends Sensor {

    public DoorSensor(String id, String location, String type) {
        super(id, location, type);
    }

    @Override
    protected String nonTrippedMessage() {
        return getLocation() + " is closed";
    }

    @Override
    protected String trippedMessage() {
        return getLocation() + " is open";
    }

    public String getType() {
        return DOOR;
    }
}
