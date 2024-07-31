import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerate() throws IOException {
        System.out.println("Start1");
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
    public void testGenerateWithWrongPath() {
        System.out.println("Start2");
        var expected = "files were lost";
        String actuals = null;
        try {
            actuals = Differ.generate(".\\resources\\file1.json", ".\\resources\\file2.json", "stylish");
        } catch (Exception e) {
            actuals = "files were lost";
        }
        assertEquals(expected, actuals);
    }
}
