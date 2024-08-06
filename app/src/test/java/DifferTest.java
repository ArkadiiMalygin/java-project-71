import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerate() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/file1.json",
                    "src/test/resources/file2.json", "stylish");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForFile1and2Stylish.txt")), actuals);
    }

    @Test
    public void testGeneratePlain() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/file1.json",
                    "src/test/resources/file2.json", "plain");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForFile1and2StylishInPlain.txt")), actuals);
    }

    @Test
    public void testGenerateJSON() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/file1.json",
                    "src/test/resources/file2.json", "json");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForFile1and2StylishInLine.txt")), actuals);
    }

    @Test
    public void testGenerateWithWrongPath() {
        var expected = "files were lost";
        String actuals = null;
        try {
            actuals = Differ.generate(".\\resources\\file1.json", ".\\resources\\file2.json", "stylish");
        } catch (Exception e) {
            actuals = "files were lost";
        }
        assertEquals(expected, actuals);
    }

    @Test
    public void testGenerateOnBigFilesPLain() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/bigFile1.json",
                    "src/test/resources/bigFile2.json", "plain");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForBigFile1and2Plain.txt")), actuals);
    }

    @Test
    public void testGenerateOnBigFilesStylish() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/bigFile1.json",
                    "src/test/resources/bigFile2.json", "stylish");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForBigFile1and2Stylish.txt")), actuals);
    }

    @Test
    public void testGenerateOnBigFilesJSON() throws IOException {
        String actuals = null;
        try {
            actuals = Differ.generate("src/test/resources/bigFile1.json",
                    "src/test/resources/bigFile2.json", "JSON");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForBigFile1and2JSON.txt")), actuals);
    }


}
