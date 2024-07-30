import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerate() {
        System.out.println("Start1");
        var expected = "{\n" + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: null\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actuals = null;
        try {
            System.out.println(System.getProperty("user.dir"));
            actuals = Differ.generate("./resources/file1.json", "./resources/file2.json", "stylish");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
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
