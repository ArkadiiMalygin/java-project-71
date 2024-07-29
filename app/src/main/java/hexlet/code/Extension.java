package hexlet.code;

public class Extension {
    public static String getExtension(String filepath) {
        return filepath.substring(filepath.lastIndexOf('.'));
    }
}
