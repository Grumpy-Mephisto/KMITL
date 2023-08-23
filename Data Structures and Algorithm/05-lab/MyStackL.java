public class MyStackL implements MyStack<Double> {
    private Node head = null;

    private class Node {
        double data;
        Node next;

        public Node(double data) {
            this.data = data;
        }
    }

    public void push(Double data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Double pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Double data = head.data;
        head = head.next;
        return data;
    }

    public Double top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head ");
        Node current = head;
        while (current != null) {
            sb.append("→ [");
            sb.append(current.data);
            sb.append("] ");
            current = current.next;
        }
        sb.append("→ null");
        return sb.toString();
    }
}
