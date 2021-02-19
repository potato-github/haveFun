package aes;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SignHelper {

    public static String getSignStr(Map<String,Object> map){
        StringBuilder sb = new StringBuilder();
        map = sortMapByKey(map);
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if (!"signature".equals(entry.getKey())) {
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
        }
        return sb.toString();

    }

    public static Map<String,Object> sortMapByKey(Map<String,Object> map) {
        Map<String,Object> sortMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sortMap.putAll(map);
        return sortMap;
    }
}
