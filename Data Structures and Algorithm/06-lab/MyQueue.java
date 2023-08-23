public interface MyQueue<E> {
    void enqueue(E e);

    E dequeue();

    E front();

    boolean isFull();

    boolean isEmpty();

    int size();
}
