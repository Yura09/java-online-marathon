import java.util.*;
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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Water", 100);
        map.put("Arabica", 20);
        return map;
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
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Water", 50);
        map.put("Arabica", 20);

        return map;
    }
}

class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    public Map<String, Integer> makeDrink() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Water", 100);
        map.put("Arabica", 20);
        map.put("Milk", 50);

        return map;
    }
}

class MyUtils {
    /*
    [Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
    Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6],
    Caffee [name=Caffee, rating=6]]
    you should get
    {Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
     */
    public static void main(String[] args) {
        List<Caffee> list = new ArrayList<>();
        list.add(new Espresso("Espresso", 8));
        list.add(new Cappuccino("Cappuccino", 10));
        list.add(new Espresso("Espresso", 10));
        list.add(new Cappuccino("Cappuccino", 6));
        list.add(new Caffee("Caffee", 6));
        System.out.println(new MyUtils().averageRating(list));
    }

    public Map<String, Double> averageRating(List<Caffee> coffees) {
        // First pass
        Map<String, List<Double>> firstPass = new HashMap<>();
        for (Caffee caffee : coffees) {
            String name = caffee.getName();
            if (firstPass.containsKey(name)) {
                firstPass.get(name).add((double) caffee.getRating());

            } else {
                List<Double> rating = new ArrayList<>();
                rating.add((double) caffee.getRating());
                firstPass.put(name, rating);
            }
        }

        // Second pass
        Map<String, Double> results = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : firstPass.entrySet()) {
            Double average = calcAverage(entry.getValue());
            results.put(entry.getKey(), average);

        }
        return results;
    }

    private double calcAverage(List<Double> values) {
        int result = 0;
        for (double value : values) {
            result += value;
        }
        return result / values.size();
    }
}
