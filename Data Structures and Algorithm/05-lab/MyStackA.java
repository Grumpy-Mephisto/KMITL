import java.util.ArrayDeque;
import java.util.Deque;

public class MyStackA implements MyStack<Double> {
    private Deque<Double> stack;
    private int capacity;

    public MyStackA(int capacity) {
        this.capacity = capacity;
        stack = new ArrayDeque<>(capacity);
    }

    public void push(Double element) {
        if (!isFull()) {
            stack.push(element);
        } else {
            System.out.println("Stack is full");
        }
    }

    public Double pop() {
        if (!isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public Double top() {
        if (!isEmpty()) {
            return stack.peek();
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
}
