public class MyQueueA implements MyQueue<String> {
    private String[] queue;
    private int size;
    private int count;
    private int front;
    private int rear;

    public MyQueueA(int size) {
        this.size = size;
        queue = new String[size];
        count = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(String s) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = s;
        rear = (rear + 1) % size;
        count++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        String s = queue[front];
        front = (front + 1) % size;
        count--;
        return s;
    }

    public String front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[front];
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
        for (int i = front; i != rear; i = (i + 1) % size) {
            sb.append(queue[i]).append(", ");
        }
        if (!isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
