package formattertest;

import hexlet.code.formatters.Stylish;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StylishTest {
    @Test
    public void testGetStylish() throws IOException {


        ArrayList<Map<String, Object>> map = new ArrayList<>();
        map.add(new HashMap<String, Object>() {{
                put("key", "follow");
                put("value", false);
                put("state", 2);
                put("updatedTo", null);
            }});
        map.add(new HashMap<String, Object>() {{
                put("key", "host");
                put("value", "hexlet.io");
                put("state", 0);
                put("updatedTo", null);
            }});
        map.add(new HashMap<String, Object>() {{
                put("key", "proxy");
                put("value", "123.234.53.22");
                put("state", 2);
                put("updatedTo", null);
            }});
        map.add(new HashMap<String, Object>() {{
                put("key", "timeout");
                put("value", 50);
                put("state", 1);
                put("updatedTo", 20);
            }});
        map.add(new HashMap<String, Object>() {{
                put("key", "verbose");
                put("value", null);
                put("state", 3);
                put("updatedTo", true);
            }});

        String actuals = null;
        try {
            actuals = Stylish.getStylish(map);
        } catch (Exception e) {
            System.out.println("files were lost");
        }
        assertEquals(Files.readString(Path.of("src/test/resources/expectedForFile1and2Stylish.txt")), actuals);
    }
}
