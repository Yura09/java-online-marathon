import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static BinaryOperator<String> greetingOperator = (x, y) -> "Hello " + x + " " + y + "!!!";
    
    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {

        return people.stream().flatMap(c-> Stream.of(greetingOperator.apply(c.name,c.surname))).collect(Collectors.toList());
    }    
}
