package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate(String filepath1, String filepath2) throws IOException {
        ArrayList<KeyValue> result = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map1 = objectMapper.readValue(new File(filepath1), new TypeReference<Map<String,String>>(){});
        Map<String, String> map2 = objectMapper.readValue(new File(filepath2), new TypeReference<Map<String,String>>(){});


        for (Map.Entry<String, String> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())){
                if (map2.get(entry.getKey()).equals(entry.getValue())) {
                    result.add(new KeyValue(" ", entry.getKey(), entry.getValue()));
                } else {
                    result.add(new KeyValue("-", entry.getKey(), entry.getValue()));
                    result.add(new KeyValue("+", entry.getKey(), map2.get(entry.getKey())));
                }
            } else {
                result.add(new KeyValue("-", entry.getKey(), entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                result.add(new KeyValue("+", entry.getKey(), entry.getValue()));
            }
        }

        result.sort(Comparator.comparing(KeyValue::getKey));

        StringBuilder res = new StringBuilder("{\n");
        for (KeyValue keyValue : result) {
            res.append(keyValue);
        }
        res.append("}");

        return res.toString();
    }
}
