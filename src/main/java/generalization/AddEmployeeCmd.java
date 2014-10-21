package generalization;

import java.io.IOException;
import java.io.OutputStream;

public class AddEmployeeCmd extends Command {

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

    public byte[] getCommandChar() {
        return new byte[]{0x02};
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
        outputStream.write(getCommandChar());

        writeBody(outputStream);

        outputStream.write(footer);
    }

    private void writeBody(OutputStream outputStream) throws IOException {
        writeField(outputStream, name);
        writeField(outputStream, address);
        writeField(outputStream, city);
        writeField(outputStream, state);
        writeField(outputStream, yearlySalary);
    }
}