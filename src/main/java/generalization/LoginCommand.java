package generalization;

public class LoginCommand extends Command {

    public LoginCommand(String userName, String passwd) {
        fields.add(userName);
        fields.add(passwd);
    }

    public byte[] getCommandChar() {
        return new byte[]{0x01};
    }
}


