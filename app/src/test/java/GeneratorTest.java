import hexlet.code.Generator;
import hexlet.code.MapCreator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {
    @Test
    public void testGetDiff() {
        System.out.println("Start5");
        ArrayList<Map<String, Object>> expected = new ArrayList<>();
        expected.add(new HashMap<String, Object>() {{
                put("key", "follow");
                put("value", false);
                put("state", 2);
                put("updatedTo", null);
            }});
        expected.add(new HashMap<String, Object>() {{
                put("key", "host");
                put("value", "hexlet.io");
                put("state", 0);
                put("updatedTo", null);
            }});
        expected.add(new HashMap<String, Object>() {{
                put("key", "proxy");
                put("value", "123.234.53.22");
                put("state", 2);
                put("updatedTo", null);
            }});
        expected.add(new HashMap<String, Object>() {{
                put("key", "timeout");
                put("value", 50);
                put("state", 1);
                put("updatedTo", 20);
            }});
        expected.add(new HashMap<String, Object>() {{
                put("key", "verbose");
                put("value", null);
                put("state", 3);
                put("updatedTo", true);
            }});

        ArrayList<Map<String, Object>> actuals = null;
        try {
            actuals = Generator.getDiff(MapCreator.getMap("src/test/resources/file1.yml"),
                    MapCreator.getMap("src/test/resources/file2.yml"));
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(expected, actuals);
    }
}
