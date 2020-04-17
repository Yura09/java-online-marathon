import java.util.List;
import java.util.Objects;

 abstract class Shape {
    private double width;

    public Shape(double width) {
        this.width = width;
    }

    public abstract double getPerimeter();

    public double getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Double.compare(shape.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}

class Rectang extends Shape {
    // Code
    private double height;

    public Rectang(double width, double height) {
        super(width);
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2*(getWidth() + height);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectang)) return false;
        if (!super.equals(o)) return false;
        Rectang rectang = (Rectang) o;
        return Double.compare(rectang.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }
}

class Square extends Shape {
    public Square(double width) {
        super(width);
    }


    @Override
    public double getPerimeter() {
        return 4* getWidth();
    }
    // Code

}

public class MyUtils {
    public double sumPerimeter(List<Shape> firures) {
        // Code
     firures.removeIf(Objects::isNull);
        double sum=0;
        for(Shape shape:firures){
            sum+=shape.getPerimeter();
        }
        return sum;
    }
}
