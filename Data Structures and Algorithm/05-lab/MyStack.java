public interface MyStack<E> {
    /**
     * Pushes an item onto the top of this stack.
     * 
     * @param data the item to be pushed onto this stack.
     * @throws IllegalStateException if this stack is full.
     */
    void push(E data);

    /**
     * Removes the object at the top of this stack and returns that object as the value of this
     * function.
     * 
     * @return The object at the top of this stack.
     * @throws IllegalStateException if this stack is empty.
     */
    E pop();

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * 
     * @return The object at the top of this stack.
     * @throws IllegalStateException if this stack is empty.
     */
    E top();

    /**
     * Returns true if this stack is full.
     * 
     * @return true if this stack is full.
     * @return false if this stack is not full.
     */
    boolean isFull();

    /**
     * Returns true if this stack is empty.
     * 
     * @return true if this stack is empty.
     * @return false if this stack is not empty.
     */
    boolean isEmpty();
}
