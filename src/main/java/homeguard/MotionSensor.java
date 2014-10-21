package homeguard;

public class MotionSensor extends Sensor{

    public MotionSensor(String id, String location, String type) {
        super(id, location, type);
    }

    public String getType(){
        return MOTION;
    }
}
