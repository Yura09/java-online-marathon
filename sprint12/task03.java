import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Interactor {
    public final static Object obj = new Object();
    int x;

    public static void main(String[] args) {
        threadExample.threadRun();
    }

     public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {

        synchronized (obj) {

            System.out.println("Serving thread running\n" +
                    "Serving thread initializes the key");
            x = uo.apply(initializer);
            System.out.println("key = " + x);

                obj.wait();
            
            System.out.println("Serving thread resumed");

        }

    }

    public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
        Thread.sleep(2000);
        synchronized (obj) {


                System.out.println("Consuming thread received the key. key = " + x);
                //your implementation here

                x = bo.apply(x, operand2);
                System.out.println("Consuming thread changed the key. key = " + x);
                obj.notify();
            }
    }
}
