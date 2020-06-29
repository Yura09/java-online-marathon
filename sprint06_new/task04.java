import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    DecisionMethod goShopping = (String n, int d) -> n.equals("product1") && d > 10; //your definition here

    Person(String name) {
        this.name = name;
    }
}

interface DecisionMethod {
    boolean decide(String name, int discount);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        return (int) clients.stream().filter(c -> c.decide(product, percent)).count();

    }
}
