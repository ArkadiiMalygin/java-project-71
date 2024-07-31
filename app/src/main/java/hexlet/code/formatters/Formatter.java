package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String getString(List<Map<String, Object>> map, String format)
            throws IllegalAccessException, IOException {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(map);
            case "Plain", "plain" -> Plain.getPlain(map);
            case "JSON", "json", "Json" -> JSON.getJson(map);
            default -> throw new IllegalAccessException();
        };
    }
}
