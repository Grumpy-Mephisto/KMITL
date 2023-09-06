public interface InterfaceLinkedList<E> {
    /**
     * Add an element to the end of the list
     * 
     * @param e the element to add
     */
    public void add(E e);

    /**
     * Add an element to the specified index
     * 
     * @param index the index to add the element
     * @param e the element to add
     */
    public void add(int index, E e);

    /**
     * Get the element at the specified index
     * 
     * @param index the index of the element to get
     * @return the element at the specified index
     */
    public E get(int index);

    /**
     * Get the index of the specified element
     * 
     * @param e the element to search for
     * @return the index of the specified element
     */
    public int indexOf(E e);

    /**
     * Check if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Remove the specified element
     * 
     * @param e the element to remove
     * @return true if the element is removed, false otherwise
     */
    public boolean remove(E e);

    /**
     * Remove the element at the specified index
     * 
     * @param index the index of the element to remove
     * @return the element that is removed
     */
    public E remove(int index);

    /**
     * Set the element at the specified index
     * 
     * @param index the index of the element to set
     * @param e the element to set
     * @return the element that is replaced
     */
    public E set(int index, E e);

    /**
     * Get the size of the list
     * 
     * @return the size of the list
     */
    public int size();
}
