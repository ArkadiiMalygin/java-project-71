package hexlet.code.formatters;

import hexlet.code.KeyValue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static hexlet.code.Generator.ADDED_STATE;
import static hexlet.code.Generator.CHANGED_STATE;
import static hexlet.code.Generator.DELETED_STATE;
import static hexlet.code.Generator.DEPRECATED_STATE;
import static hexlet.code.Generator.UNTOUCHED_STATE;

public class Formatter {

    public static String getString(List<Map<String, Object>> map, String format) throws IllegalAccessException, IOException {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(map);
            case "Plain", "plain" -> Plain.getPlain(map);
            case "JSON", "json", "Json" -> JSON.getJson(map);
            default -> throw new IllegalAccessException();
        };
    }
}
