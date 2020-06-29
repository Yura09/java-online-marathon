import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {
    
  public static int getCount(int[] numbers, Predicate<Integer> func) {

          return (int) Arrays.stream(numbers).boxed().filter(func).count();
    }
}
