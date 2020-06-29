import java.util.function.Predicate;
import java.util.Set;

class MyUtils{
   
  static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>>set){
       
        return  set.stream().reduce(Predicate::and).get();
    }
}
