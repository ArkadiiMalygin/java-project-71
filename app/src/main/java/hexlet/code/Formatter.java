package hexlet.code;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static hexlet.code.Generator.ADDED_STATE;
import static hexlet.code.Generator.CHANGED_STATE;
import static hexlet.code.Generator.DELETED_STATE;
import static hexlet.code.Generator.DEPRECATED_STATE;
import static hexlet.code.Generator.UNTOUCHED_STATE;

public class Formatter {


    public static String getJson(List<KeyValue> list) {
        StringBuilder res = new StringBuilder("[\n");
        for (KeyValue keyValue : list) {
            res.append(keyValue.toMap());
        }
        res.append("]");
        return res.toString();

    }

    public static String getStylish(List<KeyValue> list) {
        StringBuilder res = new StringBuilder("{\n");
        for (KeyValue keyValue : list) {
            res.append(keyValue);
        }
        res.append("}");
        return res.toString();
    }

    public static String getPlain(List<KeyValue> list) throws Exception {
        StringBuilder res = new StringBuilder("\n");
        for (KeyValue item : list) {
            switch (item.getState()) {
                case UNTOUCHED_STATE, DEPRECATED_STATE:
                    break;
                case CHANGED_STATE:
                    res.append("Property '");
                    res.append(item.getKey());
                    res.append("' was updated. From '");
                    res.append(item.getValue());
                    res.append("' to '");
                    res.append(item.getUpdatedTo());
                    res.append("'\n");
                    break;
                case DELETED_STATE:
                    res.append("Property '");
                    res.append(item.getKey());
                    res.append("' was removed");
                    res.append("\n");
                    break;
                case ADDED_STATE:
                    res.append("Property '");
                    res.append(item.getKey());
                    res.append("' was added with value: '");
                    res.append(item.getValue());
                    res.append("'");
                    res.append("\n");
                    break;
                default:
                    throw new Exception();
            }
        }
    return res.toString();
    }
}
//List<Map<String, Object>>
//   for (