import hexlet.code.Extension;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtensionTest {
    @Test
    public void testGetExtension() {
        System.out.println("Start12");
        String expected = ".yml";
        String actuals = null;
        try {
            actuals = Extension.getExtension("src/test/resources/file1.yml");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
    }
}
