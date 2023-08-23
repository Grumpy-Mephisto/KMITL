public class ComputeRPN {
    public static double Operation(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static MyStackA CreateStack(int capacity) {
        return new MyStackA(capacity);
    }

    public static double RPN(MyQueueA queue) {
        MyStackA stack = new MyStackA(queue.size());

        while (!queue.isEmpty()) {
            String token = queue.dequeue();
            if (token.matches("[0-9]+")) {
                stack.push(token);
            } else if (token.matches("[+\\-*/]")) {
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                stack.push(String.valueOf(Operation(token, a, b)));
            }
        }

        return Double.parseDouble(stack.pop());
    }
}
