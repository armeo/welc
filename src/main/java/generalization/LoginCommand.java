package generalization;

import java.io.IOException;
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

    protected int getSize() {
        return header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length +
                userName.getBytes().length + 1 +
                passwd.getBytes().length + 1;
    }

    protected void writeBody(OutputStream outputStream) throws IOException {
        writeField(outputStream, userName);
        writeField(outputStream, passwd);
    }
}


