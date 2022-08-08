package synthesizer;

public interface BoundedQueue<T> {

    /**
     * return size of the buffer
     * @return the size of the buffer
     */
    int capacity();

    /**
     * return number of items currently in the buffer
     * @return the number of items currently in the buffer
     */
    int fillCount();

    /**
     * add item x to the end
     * @param x the item x be added to the end of the buffer
     */
    void enqueue(T x);

    /**
     * delete and return item from the front
     * @return the front item of the buffer
     */
    T dequeue();

    /**
     * return (but do not delete) item from the front
     * @return the front of item of the buffer
     */
    T peek();

    /**
     * is the buffer empty (fillCount equals zero)?
     * @return whether the buffer is empty
     */
    default boolean isEmpty()
    {
        return fillCount() == 0;
    }

    /**
     * is the buffer full (fillCount is same as capacity)?
     * @return whether the buffer is full
     */
    default boolean isFull()
    {
        return capacity() == fillCount();
    }
}
