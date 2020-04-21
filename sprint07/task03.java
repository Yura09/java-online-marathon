public static void addAtoB(int a, int b) {
    
   Strategy strategy = Integer::sum;
        execute(a, b, strategy);

    
}

public static void subtractBfromA(int a, int b) {
    
    // Write your code here
     Strategy strategy = (a1, b1) -> a1 - b1;
        execute(a, b, strategy);
    
}

public static void multiplyAbyB(int a, int b) {
    
    // Write your code here
     Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        };
        execute(a, b, strategy);

    
}

public static void divideAbyB(int a, int b) {
      Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a / b;
            }
        };
        execute(a, b, strategy);

    // Write your code here
    
}
