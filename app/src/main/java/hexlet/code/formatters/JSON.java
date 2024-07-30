package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.KeyValue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSON {
    public static String getJson(List<Map<String, Object>> list) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.writeValue(new File("src/test/resources/differJson.json"), list);

        return om.writeValueAsString(list);

    }
}
