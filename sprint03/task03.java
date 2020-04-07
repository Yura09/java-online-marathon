import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public class MyUtils {
public  boolean listMapCompare(List<String> list, Map<String, String> map) {
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (!list.contains(m.getValue())) {
                return false;
            }
        }
        for (String s : list) {
            if (!map.containsValue(s)) {
                return false;
            }
        }
        return true;// Code
    }
    }
