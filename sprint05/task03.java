abstract class Animal {
    int age;
    double weight;
    
    public Animal(int age, double weight) {
        this.age = age;
        this.weight = weight;
    }

    public abstract String move();
}

class Mammal extends Animal {

    public Mammal(int age, double weight) {
        super(age, weight);
    }

    @Override
    public final String move() {
        return "run";
    }
}

final class Fish extends Animal {

    public Fish(int age, double weight) {
        super(age, weight);
    }

    @Override
    public String move() {
        return "swim";
    }
}

final class Bird extends Animal {

    public Bird(int age, double weight) {
        super(age, weight);
    }

    @Override
    public String move() {
        return "fly";
    }
}
