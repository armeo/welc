package generalization;

import java.io.OutputStream;

public class LoginCommand extends Command {

    private String userName;
    private String passwd;

    public LoginCommand(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    public byte[] getCommandChar() {
        return new byte[]{0x01};
    }

    private int getSize() {
        return header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length +
                userName.getBytes().length + 1 +
                passwd.getBytes().length + 1;
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(getCommandChar());

        writeField(outputStream, userName);
        writeField(outputStream, passwd);

        outputStream.write(footer);
    }
}


