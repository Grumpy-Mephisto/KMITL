import java.util.ArrayDeque;
import java.util.Deque;

public class MyStackA implements MyStack<String> {
    private Deque<String> stack;
    private int size;
    private int count;

    public MyStackA(int size) {
        this.size = size;
        stack = new ArrayDeque<>(size);
        count = 0;
    }

    public void push(String s) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack.push(s);
        count++;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        count--;
        return stack.pop();
    }

    public String top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack.peek();
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String s : stack) {
            sb.append(s).append(", ");
        }
        if (!isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
