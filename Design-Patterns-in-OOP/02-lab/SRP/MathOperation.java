public class MathOperation {
    private IMathOperation operation;

    public MathOperation(IMathOperation operation) {
        this.operation = operation;
    }

    public int execute(int num1, int num2) {
        return operation.calculate(num1, num2);
    }
}
