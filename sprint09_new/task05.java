import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {
   public Stream<String> nameList(Map<String, Stream<String>> map) {
         return map.values().stream().flatMap(obj -> obj).filter(Objects::nonNull).map(str -> str.replaceAll("\\s+", ""))
                .filter(s -> !s.isEmpty())
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }
}
