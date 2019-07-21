import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testGetWordsOrderedAlphabetically() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("resources/test2.txt", 1, 1);
        assertLinesMatch(new ArrayList<String>(Arrays.asList("apple", "bob", "cat", "dad", "mom")), fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("resources/test2.txt", 1, 1);
        assertLinesMatch(new ArrayList<String>(Arrays.asList("dad", "apple", "cat")), fileWordAnalyzer.getWordsContainingSubstring("a"));
    }

    @Test
    public void testGetStringsWhichPalindromes() {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("resources/test2.txt", 1, 1);
        assertLinesMatch(new ArrayList<String>(Arrays.asList("dad", "bob", "mom")), fileWordAnalyzer.getStringsWhichPalindromes());
    }
}