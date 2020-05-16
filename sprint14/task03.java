import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class MyUtils {
    public int sumEven(Stream<IntStream> stream) {
        return  stream.mapToInt(m-> m.filter(n -> n % 2 == 0 && n > 0).min().orElse(0)).sum();
    }
}
