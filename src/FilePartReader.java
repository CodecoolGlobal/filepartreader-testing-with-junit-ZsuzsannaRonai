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

    public String read () {
        String fileContent = null;
        try {
            fileContent = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public String readLines() {
        String filePart = "";
        String[] fileContent = read().split("\n");
        for (int i = fromLine - 1; i < toLine; i++) {
            filePart = filePart.concat(fileContent[i] + "\n");
        }
        return filePart;
    }
}