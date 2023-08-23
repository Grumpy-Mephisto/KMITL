import java.util.StringTokenizer;

public class ComputeInfix {
    public static MyQueueA ShuntingYard(String data) {
        MyQueueA queue = new MyQueueA(data.length());
        MyStackA stack = new MyStackA(data.length());
        StringTokenizer st = new StringTokenizer(data, "+-*/()", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.matches("[0-9]+")) {
                queue.enqueue(token);
            } else if (token.matches("[+\\-*/]")) {
                while (!stack.isEmpty() && !stack.top().equals("(")
                        && Precedence(token) <= Precedence(stack.top())) {
                    queue.enqueue(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        return queue;
    }

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

    public static double Precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }


    public static String QueueToString(MyQueueA queue) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        MyQueueA tempQueue = new MyQueueA(queue.size());
        while (!queue.isEmpty()) {
            String element = queue.dequeue();
            sb.append(element).append(", ");
            tempQueue.enqueue(element);
        }

        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        String data;
        try {
            data = args[0].replaceAll("\\s+", "");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java ComputeInfix \"<infix expression>\"");
            return;
        }
        MyQueueA queue = ShuntingYard(data);
        System.out.println("RPN: " + QueueToString(queue));

        double result = ComputeRPN.RPN(queue);
        System.out.println("Result: " + result);
    }
}
