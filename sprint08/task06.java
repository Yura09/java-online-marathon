import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        //you implementation
        return numbers.stream().filter(pr).max(Integer::compare).get();
    }
}

class User{
   
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>,Predicate<Integer>,Integer>function,Predicate<Integer>predicate){
        //implementation
       return function.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> pr) {
        //your implementation
        return getFilterdValue(MyUtils::findMaxByCondition,pr);
    }
}
