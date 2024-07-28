package hexlet.code;

import java.util.Objects;

public class KeyValue {

    String sign;
    String key;
    String value;

    @Override
    public String toString() {
        return  "  " + sign + ' ' +
                key +
                ": " + value + "\n";
    }

    public KeyValue(String sign, String key, String value) {
        this.sign = sign;
        this.key = key;
        this.value = value;
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
