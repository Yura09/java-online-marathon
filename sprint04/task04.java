import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] getXYPair() {
        return new int[]{this.x, this.y};
    }

    public double distance(int x, int y) {
        return sqrt(pow(x - this.x, 2) + pow(y - this.y, 2));
    }

    public double distance(Point point) {
        return sqrt(pow(point.x - x, 2) + pow(point.y - y, 2));
    }

    public double distance() {
        return sqrt(x * x + y * y);
    }
}
