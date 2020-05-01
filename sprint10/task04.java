import java.util.stream.IntStream;
class ArrayUtil {

   public static double averageValue(Array<? extends Number> array) {
       
        return IntStream.range(0,array.length()).mapToDouble(i->array.get(i).doubleValue()).average().orElse(0.0);
    }

    
}
