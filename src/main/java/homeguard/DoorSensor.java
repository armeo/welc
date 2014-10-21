package homeguard;

public class DoorSensor extends Sensor {

    public DoorSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType() {
        return DOOR;
    }

    public String getMessage() {
        if (!isTripped()) return getLocation() + " is closed";
        return getLocation() + " is open";
    }
}
