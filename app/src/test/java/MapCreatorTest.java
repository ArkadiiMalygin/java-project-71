
import hexlet.code.MapCreator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapCreatorTest {
    @Test
    public void testGetMap() {
        System.out.println("Start3");
        Map<String, Object> expected = Map.of("host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false);
        Map<String, Object> actuals = null;
        try {
            actuals = MapCreator.getMap("src/test/resources/file1.json");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
    }

    @Test
    public void testForJson() {
        System.out.println("Start3");
        Map<String, Object> expected = Map.of("host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false);
        Map<String, Object> actuals = null;
        try {
            actuals = MapCreator.getMap("src/test/resources/file1.json");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
    }

    @Test
    public void testForYAML() {
        System.out.println("Start3");
        Map<String, Object> expected = Map.of("proxy", "123.234.53.22",
                "host", "hexlet.io",
                "timeout", 50,
                "follow", false);
        Map<String, Object> actuals = null;
        try {
            actuals = MapCreator.getMap("src/test/resources/file1.yml");
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
    }
}
