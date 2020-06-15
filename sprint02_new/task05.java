import java.util.List;
import java.util.Objects;

interface Shape {

    public abstract double getPerimeter();

}

class Rectang implements Shape {
    private double height;
    private double width;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getHeight() {
        return height;
    }

}

class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }
    @Override
    public double getPerimeter() {
        return 4 * width;
    }
}
public class MyUtils {
    public double sumPerimeter(List<Shape> firures) {
        return firures.stream().filter(Objects::nonNull).mapToDouble(Shape::getPerimeter).sum();

    }
}
