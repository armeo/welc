package generalization;

import java.io.IOException;
import java.io.OutputStream;

public class Command {
    protected static final byte[] header = {(byte) 0xde, (byte) 0xad};
    protected static final byte[] footer = {(byte) 0xbe, (byte) 0xef};
    protected static final int SIZE_LENGTH = 1;
    protected static final int CMD_BYTE_LENGTH = 1;

    protected void writeField(OutputStream outputStream, String field) throws IOException {
        outputStream.write(field.getBytes());
        outputStream.write(0x00);
    }
}
