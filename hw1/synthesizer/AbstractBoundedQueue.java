package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    /**
     * Get the capacity of the buffer
     * @return the capacity of the buffer
     */
    @Override
    public int capacity() {
        return capacity;
    }

    /**
     * Get the occupied space of the buffer
     * @return the occupied space of the buffer
     */
    @Override
    public int fillCount() {
        return fillCount;
    }
}
