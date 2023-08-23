public class MyStackL {
    // Like MyStackA but using a linked list
    private Node<String> top;
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

    public MyStackL(int size) {
        this.size = size;
        top = null;
        count = 0;
    }

    public void push(String s) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        Node<String> node = new Node<>(s);
        node.next = top;
        top = node;
        count++;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        String s = top.data;
        top = top.next;
        count--;
        return s;
    }

    public String top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
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
        for (Node<String> node = top; node != null; node = node.next) {
            sb.append(node.data);
            if (node.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
