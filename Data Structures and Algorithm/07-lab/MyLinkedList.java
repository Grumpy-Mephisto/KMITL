public class MyLinkedList implements InterfaceLinkedList<Object> {
    public class Node {
        public Object data;
        public Node next;
    }

    public Node head;
    public int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object e) {
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void add(int index, Object e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    public int indexOf(Object e) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(e))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean remove(Object e) {
        if (head == null)
            return false;

        if (head.data.equals(e)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(e)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            Object temp = head.data;
            head = head.next;
            size--;
            return temp;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        Object temp = current.next.data;
        current.next = current.next.next;
        size--;
        return temp;
    }

    public Object set(int index, Object e) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        Object temp = current.data;
        current.data = e;
        return temp;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "[";
        Node current = head;
        while (current != null) {
            result += current.data;
            if (current.next != null)
                result += " → ";
            current = current.next;
        }
        result += "]";
        return result;
    }

    public void rotateRight(MyLinkedList list, int i) {}
}
