import java.util.ArrayDeque;
import java.util.Deque;

public class MyRPN {
    private Deque<Integer> stack;
    private int capacity;

    public MyRPN(int capacity) {
        this.capacity = capacity;
        stack = new ArrayDeque<>(capacity);
    }

    public void push(int element) {
        if (!isFull()) {
            stack.push(element);
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isFull() {
        return stack.size() >= capacity;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        MyRPN rpnCalculator = new MyRPN(10);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Pushing element: " + i);
            rpnCalculator.push(i);
        }

        System.out.println("Stack contents: " + rpnCalculator);

        while (!rpnCalculator.isEmpty()) {
            System.out.println("Popped element: " + rpnCalculator.pop());
        }

        System.out.println("Stack contents: " + rpnCalculator);
    }
}
