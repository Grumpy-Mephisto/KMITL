public interface MyStack<E> {
    void push(E element);

    E pop();

    E top();

    boolean isEmpty();

    int size();
}
