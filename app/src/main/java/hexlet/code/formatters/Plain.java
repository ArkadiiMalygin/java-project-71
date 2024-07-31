package hexlet.code.formatters;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import static hexlet.code.Generator.ADDED_STATE;
import static hexlet.code.Generator.CHANGED_STATE;
import static hexlet.code.Generator.DELETED_STATE;


public class Plain {
    public static String getPlain(List<Map<String, Object>> list) {
        StringBuilder res = new StringBuilder("\n");
        for (Map<String, Object> pair : list) {
            if (pair.get("state") == CHANGED_STATE) {
                res.append("Property '").append(pair.get("key")).append("' was updated. From ")
                        .append(plainVersion(pair.get("value"))).append(" to ")
                        .append(plainVersion(pair.get("updatedTo"))).append("\n");
            } else if (pair.get("state") == DELETED_STATE) {
                res.append("Property '").append(pair.get("key")).append("' was removed\n");
            } else if (pair.get("state") == ADDED_STATE) {
                res.append("Property '").append(pair.get("key")).append("' was added with value: ")
                        .append(plainVersion(pair.get("updatedTo"))).append("\n");
            }
        }
        return res.toString();
    }

    public static String plainVersion(Object valueObject) {
        String value;
        if (valueObject instanceof String) {
            value = "'" + valueObject + "'";
        } else if (valueObject instanceof Integer
                || valueObject instanceof Boolean) {
            value = valueObject.toString();
        } else if (Objects.isNull(valueObject)) {
            value = null;
        } else {
            value = "[complex value]";
        }
        return value;
    }
}
