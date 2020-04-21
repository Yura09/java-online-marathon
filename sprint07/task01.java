class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() { }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }
public static class PizzaBuilder{
        private Pizza pizza;
       private PizzaBuilder(){
            pizza=new Pizza();
        }
        public PizzaBuilder addCheese(String cheese){

           pizza.cheese=cheese;
           return this;
        }
        public PizzaBuilder addMeat(String meat){
            pizza.meat=meat;
            return this;
        }
        public PizzaBuilder addSeafood(String seafood){
            pizza.seafood=seafood;
            return this;
        }
        public PizzaBuilder addVegetable(String vegetable){
            pizza.vegetable=vegetable;
            return this;
        }
        public PizzaBuilder addMushroom(String mushroom){
            pizza.mushroom=mushroom;
            return this;
        }
        public Pizza build(){
            addMeat("chicken").addCheese("cheese").addVegetable("tomate").addCheese("feta");
            return pizza;
        }

}
    // Describe PizzaBuilder class here

}

class Oven {
    public static Pizza cook() {

      return Pizza.base().build();

    }
}
