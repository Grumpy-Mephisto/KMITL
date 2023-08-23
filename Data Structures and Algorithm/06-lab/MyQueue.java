public interface MyQueue<E> {
    /**
     * Inserts the specified element into this queue if it is possible to do so
     * 
     * @param e the element to add
     * @throws IllegalStateException if the element cannot be added at this time due to capacity
     *         restrictions
     * @throws NullPointerException if the specified element is null and this queue does not permit
     *         null elements
     * @throws IllegalArgumentException if some property of this element prevents it from being
     *         added to this queue
     * @return true if the element was added to this queue, else false
     */
    void enqueue(E e);

    /**
     * Retrieves and removes the head of this queue
     * 
     * @throws NoSuchElementException if this queue is empty
     * @return the head of this queue
     */
    E dequeue();

    /**
     * Retrieves, but does not remove, the head of this queue
     * 
     * @throws NoSuchElementException if this queue is empty
     * @return the head of this queue
     */
    E front();

    /**
     * Returns true if this queue is full
     * 
     * @return true if this queue is full
     */
    boolean isFull();

    /**
     * Returns true if this queue is empty
     * 
     * @return true if this queue is empty
     */
    boolean isEmpty();

    int size();
}
