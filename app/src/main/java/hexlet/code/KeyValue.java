package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class KeyValue {

    String sign;
    String key;
    String value;

    int state;

    String updatedTo;

    @Override
    public String toString() {
        return  "  " + sign + ' '
                + key
                + ": " + value + "\n";
    }

    public String toMap() {
        return  "{\"" + sign + ' '
                + key
                + "\" : \"" + value +"\"}, ";

    }

    public KeyValue(String sign, String key, String value, int state) {
        this.sign = sign;
        this.key = key;
        this.value = value;
        this.state = state;
    }

    public KeyValue(String sign, String key, String value, int state, String updatedTo) {
        this.sign = sign;
        this.key = key;
        this.value = value;
        this.state = state;
        this.updatedTo = updatedTo;
    }

    public String getUpdatedTo() {
        return updatedTo;
    }

    public int getState() {
        return state;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
