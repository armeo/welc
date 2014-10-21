package homeguard;

public class WindowSensor extends Sensor {

    public WindowSensor(String id, String location, String type) {
        super(id, location, type);
    }

    @Override
    protected String nonTrippedMessage() {
        return getLocation() + " is sealed";
    }

    @Override
    protected String trippedMessage() {
        return getLocation() + " is ajar";
    }

    public String getType() {
        return WINDOW;
    }
}
