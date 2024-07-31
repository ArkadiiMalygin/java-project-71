package hexlet.code.formatters;

import hexlet.code.KeyValue;

import java.util.List;
import java.util.Map;

import static hexlet.code.Generator.ADDED_STATE;
import static hexlet.code.Generator.CHANGED_STATE;
import static hexlet.code.Generator.DELETED_STATE;
import static hexlet.code.Generator.UNTOUCHED_STATE;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> list) {
        StringBuilder res = new StringBuilder("{\n");
        for (Map<String, Object> pair : list) {
            if (pair.get("state") == UNTOUCHED_STATE) {
                res.append("    ").append(pair.get("key")).append(": ").append(pair.get("value")).append("\n");
            } else if (pair.get("state") == CHANGED_STATE) {
                res.append("  - ").append(pair.get("key")).append(": ").append(pair.get("value")).append("\n");
                res.append("  + ").append(pair.get("key")).append(": ").append(pair.get("updatedTo")).append("\n");
            } else if (pair.get("state") == DELETED_STATE) {
                res.append("  - ").append(pair.get("key")).append(": ").append(pair.get("value")).append("\n");
            } else if (pair.get("state") == ADDED_STATE) {
                res.append("  + ").append(pair.get("key")).append(": ").append(pair.get("updatedTo")).append("\n");
            }
        }

        return res.append("}").toString();
    }
}
