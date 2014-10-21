package generalization;

public class AddEmployeeCmd extends Command {

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        fields.add(name);
        fields.add(address);
        fields.add(city);
        fields.add(state);
        fields.add(Integer.toString(yearlySalary));
    }

    public byte[] getCommandChar() {
        return new byte[]{0x02};
    }
}