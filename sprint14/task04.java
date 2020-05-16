import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Objects;
public class MyUtils {
   public long countNumbers(IntStream intNum, Stream<String> strNum) {
          return strNum.filter(Objects::nonNull).filter(x -> !x.isBlank() && !x.equals("0") && (x.contains("3") || Integer.parseInt(x) % 3 == 0)).count() +
                intNum.filter(Objects::nonNull).filter(x -> x != 0 && !Integer.toString(x).equals("0") && (Integer.toString(x).contains("3") || x % 3 == 0)).count();
      }
}
