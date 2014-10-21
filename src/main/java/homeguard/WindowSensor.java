package homeguard;

public class WindowSensor extends Sensor {

    public WindowSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType() {
        return WINDOW;
    }

    public String getMessage() {
        return isTripped() ? getLocation() + " is ajar" : getLocation() + " is sealed";
    }
}
