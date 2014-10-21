package generalization;

import java.io.OutputStream;

public class AddEmployeeCmd extends Command {
    private static final byte[] commandChar = {0x02};

    String name;
    String address;
    String city;
    String state;
    String yearlySalary;

    public AddEmployeeCmd(String name, String address, String city, String state, int yearlySalary) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.yearlySalary = Integer.toString(yearlySalary);
    }

    private int getSize() {
        return header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length +
                name.getBytes().length + 1 +
                address.getBytes().length + 1 +
                city.getBytes().length + 1 +
                state.getBytes().length + 1 +
                yearlySalary.getBytes().length + 1;
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        writeField(outputStream, name);
        writeField(outputStream, address);
        writeField(outputStream, city);
        writeField(outputStream, state);
        writeField(outputStream, yearlySalary);
        outputStream.write(footer);
    }
}