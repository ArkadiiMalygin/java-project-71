package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    public static final Integer UNTOUCHED_STATE = 0;
    public static final Integer CHANGED_STATE = 1;
    public static final Integer DEPRECATED_STATE = 4;
    public static final Integer DELETED_STATE = 2;
    public static final Integer ADDED_STATE = 3;

    public static ArrayList<Map<String, Object>> getDiff(Map<String, Object> map1, Map<String, Object> map2) {
        ArrayList<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                if ((map2.get(entry.getKey()) == null && entry.getValue() == null)
                        || (map2.get(entry.getKey()) != null && entry.getValue() != null
                        && map2.get(entry.getKey()).toString().equals(entry.getValue().toString()))) {
                    var map = new HashMap<String, Object>();
                    map.put("key", entry.getKey());
                    map.put("value", entry.getValue());
                    map.put("state", UNTOUCHED_STATE);
                    map.put("updatedTo", null);
                    result.add(map);
                } else {
                    var map = new HashMap<String, Object>();
                    map.put("key", entry.getKey());
                    map.put("value", entry.getValue());
                    map.put("state", CHANGED_STATE);
                    map.put("updatedTo", map2.get(entry.getKey()));
                    result.add(map);
                }
            } else {
                var map = new HashMap<String, Object>();
                map.put("key", entry.getKey());
                map.put("value", entry.getValue());
                map.put("state", DELETED_STATE);
                map.put("updatedTo", null);
                result.add(map);
            }
        }
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                var map = new HashMap<String, Object>();
                map.put("key", entry.getKey());
                map.put("value", null);
                map.put("state", ADDED_STATE);
                map.put("updatedTo", entry.getValue());
                result.add(map);
            }
        }
        result.sort((o1, o2) -> o1.get("key").toString().compareToIgnoreCase(o2.get("key").toString()));
        return result;
    }
}
