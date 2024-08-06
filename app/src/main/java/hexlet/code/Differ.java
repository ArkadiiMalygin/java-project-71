package hexlet.code;

import java.util.ArrayList;
import java.util.Map;

import hexlet.code.formatters.Formatter;


public class Differ {

    public static final String YML = ".yml";
    public static final String JSON = ".json";
    public static final String STYLISH = "stylish";

    public static String generate(String filepath1, String filepath2, String format) throws Exception {




        Map<String, Object> map1 = MapCreator.getMap(filepath1);
        Map<String, Object> map2 = MapCreator.getMap(filepath2);


        ArrayList<Map<String, Object>> result = Generator.getDiff(map1, map2);

        return Formatter.getString(result, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1,filepath2, STYLISH);
    }
}
