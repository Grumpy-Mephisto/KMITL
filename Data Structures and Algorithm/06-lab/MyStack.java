public interface MyStack<E> {
    /**
     * Pushes an element onto the top of this stack
     * 
     * @param element the element to be pushed onto this stack
     * @throws NullPointerException if the specified element is null
     */
    void push(E element);

    /**
     * Removes the element at the top of this stack and returns that element as the value of this
     * function
     * 
     * @throws NoSuchElementException if this stack is empty
     * @return the element at the top of this stack
     */
    E pop();

    /**
     * Looks at the element at the top of this stack without removing it from the stack
     * 
     * @throws NoSuchElementException if this stack is empty
     * @return the element at the top of this stack
     */
    E top();

    /**
     * Returns true if this stack is full
     * 
     * @return true if this stack is full
     */
    boolean isEmpty();

    /**
     * Returns true if this stack is empty
     * 
     * @return true if this stack is empty
     */
    int size();
}
