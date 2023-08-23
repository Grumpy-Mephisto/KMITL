public interface MyStack<E> {
    void push(E data);

    E pop();

    E top();

    boolean isFull();

    boolean isEmpty();
}
