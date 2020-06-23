import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
public class MyUtils {
    
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
       return new HashSet<>(list).containsAll(map.values());
    }
}
