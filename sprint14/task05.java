import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyUtils {
   public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Set<Integer> allItems = new HashSet<>();
    
        return stream.filter(Objects::nonNull).filter(n->!allItems.add(n)).distinct().sorted();
    }
}
