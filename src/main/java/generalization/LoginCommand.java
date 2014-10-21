package generalization;
/*
 * Created by IntelliJ IDEA.
 * User: bbutton
 * Date: Jul 31, 2002
 * Time: 11:30:29 PM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */

import java.io.OutputStream;

public class LoginCommand extends Command {

    private static final byte[] commandChar = {0x01};

    private String userName;
    private String passwd;

    public LoginCommand(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    private int getSize() {
        return header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length +
                userName.getBytes().length + 1 +
                passwd.getBytes().length + 1;
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        outputStream.write(userName.getBytes());
        outputStream.write(0x00);
        outputStream.write(passwd.getBytes());
        outputStream.write(0x00);
        outputStream.write(footer);
    }
}


