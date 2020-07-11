import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
   public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
       Map<String, List<String>> locationMap = list.stream().flatMap(obj -> obj).filter(Objects::nonNull)
                .map(str -> {
                    final String code;
                    switch (str.replaceAll("[^0-9]", "").length()) {
                        case 5:
                            code = "err";
                            break;
                        case 7:
                            code = "loc";
                            break;
                        default:
                            code = "";
                    }
                    return code + str.replaceAll("[^0-9]", "");
                }).filter(s -> !s.isBlank() || !s.isEmpty()).distinct().sorted()
                .collect(Collectors.groupingBy(str -> str.substring(0, 3), Collectors.mapping(str -> str.substring(3), Collectors.toList())));

        Map<String, Stream<String>> map = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> e : locationMap.entrySet()) {
            map.put(e.getKey(), e.getValue().stream());
        }
        return map;
    }
}
