package generalization;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class Command {
    protected static final byte[] header = {(byte) 0xde, (byte) 0xad};
    protected static final byte[] footer = {(byte) 0xbe, (byte) 0xef};
    protected static final int SIZE_LENGTH = 1;
    protected static final int CMD_BYTE_LENGTH = 1;

    public  ArrayList<String> fields = new ArrayList<String>();

    protected abstract byte[] getCommandChar();

    protected void writeField(OutputStream outputStream, String field) throws IOException {
        outputStream.write(field.getBytes());
        outputStream.write(0x00);
    }

    public void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(getCommandChar());

        writeBody(outputStream);

        outputStream.write(footer);
    }

    protected int getSize() {
        return header.length + SIZE_LENGTH + CMD_BYTE_LENGTH + footer.length + getBodySize();
    }

    protected void writeBody(OutputStream outputStream) throws IOException {
        for(String field : fields) {
            writeField(outputStream, field);
        }
    }

    protected int getBodySize(){
        int bodySize = 0;
        for(String field : fields) {
            bodySize += field.getBytes().length + 1;
        }

        return bodySize;
    }
}
