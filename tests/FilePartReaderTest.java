import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testConstructorThrowsNoSuchFileException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(NoSuchFileException.class, () -> filePartReader.read());
    }

    @Test
    public void testSetupFromLineLower0ThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("", 0, 3);
        });
    }

    @Test
    public void testSetupToLineLowerFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("", 3, 2);
        });
    }

    @Test
    public void testRead() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 1);
        try {
            assertEquals("a\nb\nc", filePartReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadLines() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 1);
        assertEquals("a\n", filePartReader.readLines());
        filePartReader.setup("resources/test.txt", 1, 2);
        assertEquals("a\nb\n", filePartReader.readLines());
        filePartReader.setup("resources/test.txt", 1, 3);
        assertEquals("a\nb\nc\n", filePartReader.readLines());
        filePartReader.setup("resources/test.txt", 2, 2);
        assertEquals("b\n", filePartReader.readLines());
        filePartReader.setup("resources/test.txt", 2, 3);
        assertEquals("b\nc\n", filePartReader.readLines());
    }
}