import java.util.*;
import java.util.stream.Collectors;

abstract class Shape {
    // Code
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Circle extends Shape {
    // Code
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
      return Math.PI*radius*radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}

class Rectangle extends Shape {
    // Code
  private   double height;
   private double width;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return height*width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, width);
    }
}

 class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {

       double longestCircleArea=shapes.stream().filter(obj -> obj instanceof Circle).distinct().mapToDouble(Shape::getArea).max().orElse(0);
        double longestCRectangleArea=shapes.stream().filter(obj -> obj instanceof Rectangle).distinct().mapToDouble(Shape::getArea).max().orElse(0);
        List<Shape>resultList=new ArrayList<>();
        for(Shape shape:shapes){
            if(Double.compare(shape.getArea(),longestCircleArea)==0|| Double.compare(shape.getArea(),longestCRectangleArea)==0){
                resultList.add(shape);
            }
        }
        return resultList;
    }
}
