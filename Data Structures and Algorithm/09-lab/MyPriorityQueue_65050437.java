import java.util.ArrayList;
import code.PriorityQueueInterface;

public class MyPriorityQueue_65050437 implements PriorityQueueInterface {
    ArrayList<Integer> queue = new ArrayList<>();
    int MAX_SIZE = 6;

    public void enqueue(int e) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        queue.add(e);
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        queue.remove(0);
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public boolean isFull() {
        return queue.size() == MAX_SIZE;
    }

    @Override
    public String toString() {
        return String.format("MyPriorityQueue_65050437{queue=%s}", queue);
    }
}
