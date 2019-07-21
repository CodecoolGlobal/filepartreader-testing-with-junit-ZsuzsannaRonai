import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        this.filePath = "some.txt";
        this.fromLine = 4;
        this.toLine = 5;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1) {
            throw new IllegalArgumentException("Starting line number can not be less than 1");
        } else if (toLine < fromLine) {
            throw new IllegalArgumentException("Starting line number can higher than ending line number");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read () throws IOException {
        return new String ( Files.readAllBytes( Paths.get(filePath) ) );
    }

    public String readLines() {
        String filePart = "";
        String[] fileContent = new String[0];
        try {
            fileContent = read().split("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = fromLine - 1; i < toLine; i++) {
            filePart = filePart.concat(fileContent[i] + "\n");
        }
        return filePart;
    }
}