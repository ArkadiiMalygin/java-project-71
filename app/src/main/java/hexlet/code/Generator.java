package hexlet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Generator {

    public static final int UNTOUCHED_STATE = 0;
    public static final int CHANGED_STATE = 1;
    public static final int DEPRECATED_STATE = 4;
    public static final int DELETED_STATE = 2;
    public static final int ADDED_STATE = 3;

    public static ArrayList<KeyValue> getDiff(Map<String,String> map1, Map<String,String> map2) {
        ArrayList<KeyValue> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                if ((map2.get(entry.getKey()) == null && entry.getValue() == null)
                        || ( map2.get(entry.getKey()) != null && entry.getValue() != null
                        && map2.get(entry.getKey()).equals(entry.getValue()))) {
                    result.add(new KeyValue(" ", entry.getKey(), entry.getValue(), UNTOUCHED_STATE));
                } else {
                    result.add(new KeyValue("-", entry.getKey(), entry.getValue(), CHANGED_STATE, map2.get(entry.getKey())));
                    result.add(new KeyValue("+", entry.getKey(), map2.get(entry.getKey()), DEPRECATED_STATE));
                }
            } else {
                result.add(new KeyValue("-", entry.getKey(), entry.getValue(), DELETED_STATE));
            }
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                result.add(new KeyValue("+", entry.getKey(), entry.getValue(), ADDED_STATE));
            }
        }
        result.sort(Comparator.comparing(KeyValue::getKey));
        return result;
    }
}
