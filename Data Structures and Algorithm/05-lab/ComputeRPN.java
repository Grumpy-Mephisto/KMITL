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

    public static double RPN(String data) {
        MyStackA stack = CreateStack(data.length());
        String[] arr = data.split(" ");

        for (String s : arr) {
            if (s.matches("[0-9]+")) {
                stack.push(Double.parseDouble(s));
            } else {
                double a = stack.pop();
                double b = stack.pop();
                double result = Operation(s, b, a);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String data;
        try {
            data = args[0].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java ComputeRPN \"<RPN expression>\"");
            return;
        }

        System.out.println("RPN expression: " + data);
    }
}
