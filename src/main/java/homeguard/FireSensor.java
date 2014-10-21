package homeguard;

public class FireSensor extends Sensor{

    public FireSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType(){
        return FIRE;
    }
}
