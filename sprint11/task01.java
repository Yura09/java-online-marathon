class Operation{
     public static int squareRectangle(int a, int b)  {
        //your code
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }
        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        //your code
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return 0;
        }

    }  
}
