package homeguard;

public class WindowSensor extends Sensor {

    public WindowSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType() {
        return WINDOW;
    }

    public String getMessage() {
        if (!isTripped()) return getLocation() + " is sealed";
        return getLocation() + " is ajar";
    }
}
