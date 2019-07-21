import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        String line = filePartReader.readLines();
        line = line.replaceAll("\\W", " ").trim().replaceAll("\\s{2,}", " ");
        List<String> lineWordsList = Arrays.asList(line.split(" "));
        lineWordsList.sort(String.CASE_INSENSITIVE_ORDER);
        return lineWordsList;
    }

    public List<String> getWordsContainingSubstring (String subString) {
        String line = filePartReader.readLines();
        line = line.replaceAll("\\W", " ").trim().replaceAll("\\s{2,}", " ");
        List<String> lineWordsList = Arrays.asList(line.split(" "));
        List<String> resultWordsList = new ArrayList<>();
        for (String word : lineWordsList) {
            if (word.contains(subString)) {
                resultWordsList.add(word);
            }
        }
        return resultWordsList;
    }

    public List<String> getStringsWhichPalindromes () {
        String line = filePartReader.readLines();
        line = line.replaceAll("\\W", " ").trim().replaceAll("\\s{2,}", " ");
        List<String> lineWordsList = Arrays.asList(line.split(" "));
        List<String> resultWordsList = new ArrayList<>();
        for (String word : lineWordsList) {
            if (word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
                resultWordsList.add(word);
            }
        }
        return resultWordsList;
    }
}
