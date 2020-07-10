import java.util.function.BinaryOperator;
public class ParallelCalculator implements Runnable {
    BinaryOperator<Integer> operator;
    int result;
    int operand1;
    int operand2;

    public ParallelCalculator(BinaryOperator<Integer> operator, int operand1, int operand2) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run() {
        result = operator.apply(operand1, operand2);
    }
}
