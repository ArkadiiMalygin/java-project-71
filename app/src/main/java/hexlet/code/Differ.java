package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {

    public static final String YML = ".yml";
    public static final String JSON = ".json";

    public static String generate(String filepath1, String filepath2) throws Exception {




        Map<String, String> map1 = MapCreator.getMap(filepath1);
        Map<String, String> map2 = MapCreator.getMap(filepath2);


        ArrayList<KeyValue> result = Generator.getDiff(map1, map2);
        ObjectMapper om = new ObjectMapper();
        om.writeValue(new File("src/test/resources/differJson.json"), Formatter.getJson(result));
        return Formatter.getPlain(result);
    }
}
