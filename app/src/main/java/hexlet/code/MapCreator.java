package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static hexlet.code.Differ.JSON;
import static hexlet.code.Differ.YML;

public class MapCreator {

    public static Map<String, String> getMap(String filepath) throws IOException {
        String extension = Extension.getExtension(filepath);
        Map<String, Object> map = new HashMap<>();
        if (extension.equals(YML)) {
            map = MapCreator.forYAML(filepath);
        } else if ((extension.equals(JSON))) {
            map = MapCreator.forJson(filepath);
        } else {
            throw new IOException();
        }
        Map<String, String> resMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (Objects.isNull(entry.getValue())) {
                resMap.put(entry.getKey(), null);
            } else {
                resMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return resMap;
    }

    public static Map<String,Object> forJson(String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filepath),
                new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String,Object> forYAML(String filepath) throws IOException {
        ObjectMapper objectMapper = new YAMLMapper();
        return objectMapper.readValue(new File(filepath),
                new TypeReference<Map<String, Object>>() { });

    }
}
