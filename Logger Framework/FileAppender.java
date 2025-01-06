
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {

    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void append(LogMessage message) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(message.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}