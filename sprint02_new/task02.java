import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface DrinkReceipt {
    // Code
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
    // Code
}

interface Rating {
    // Code
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private Map<String, Integer> ingredients;
    private String name;
    private int rating;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        ingredients = new HashMap<>();
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 100)
                .addComponent("Arabica", 20);
        return getIngredients();
    }

    @Override
    public int getRating() {
        return rating;
    }
    // Code
}

class Espresso extends Caffee {
    public Espresso(String name, int rating) {
        super(name, rating);
    }

    // Code
    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        addComponent("Water", 50);

        return getIngredients();
    }
}

class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    public Map<String, Integer> makeDrink() {
        super.makeDrink();
        addComponent("Milk", 50);
        return getIngredients();
    }
}

public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        return coffees.stream().collect(Collectors.groupingBy(Caffee::getName, Collectors.averagingDouble(Caffee::getRating)));
    }
}
