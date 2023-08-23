public class MyQueueL implements MyQueue<String> {
    private Node<String> front;
    private Node<String> rear;
    private int size;
    private int count;

    public class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public E getData() {
            return data;
        }
    }

    public MyQueueL(int size) {
        this.size = size;
        front = null;
        rear = null;
        count = 0;
    }

    public void enqueue(String s) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        Node<String> node = new Node<>(s);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        count++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        String s = front.data;
        front = front.next;
        count--;
        return s;
    }

    public String front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
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
        for (Node<String> node = front; node != null; node = node.next) {
            sb.append(node.data).append(", ");
        }
        if (!isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}


