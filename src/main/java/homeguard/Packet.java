package homeguard;

public class Packet {

    private String sensorId;
    private String sensorStatus;

    public Packet(String packet){
        String[] tokens = packet.split(",");

        this.sensorId = tokens[0];
        this.sensorStatus = tokens[1];
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getSensorStatus() {
        return sensorStatus;
    }
}