package homeguard;

public class FireSensor extends Sensor {

    public FireSensor(String id, String location, String type) {
        super(id, location, type);
    }

    @Override
    protected String nonTrippedMessage() {
        return getLocation() + " temperature is normal";
    }

    @Override
    protected String trippedMessage() {
        return getLocation() + " is on FIRE!";
    }

    public String getType() {
        return FIRE;
    }
}
