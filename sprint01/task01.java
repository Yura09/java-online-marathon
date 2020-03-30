public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static float doubleNumber(double number) {

        return 2 * (float) number;
    }

    public static int century(int year) {

        if (year <= 100) {
            return 1;
        }
        if (year % 100 == 0) {
            return year / 100;
        }
        return year / 100 + 1;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        int m = 0;
        while (number > 0) {
            m = number % 10;
            sum += m;
            number /= 10;
        }
        return sum;

    }

    public static boolean isLeapYear(int year) {

        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }

    }
}
