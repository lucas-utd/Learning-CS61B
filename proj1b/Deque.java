
/** Deque interface for ArrayDeque and LinkedListDeque */
public interface Deque<T> {

    /** Add an item to the front of the deque */
    public void addFirst(T item);

    /** Adds an item to the back of the deque */
    public void addLast(T item);

    /** Check whether the deque is empty */
    public boolean isEmpty();

    /** return the number of items in the deque */
    public int size();

    /** Prints the items in the deque from first to last, separated by a space */
    public String printDeque();

    /** Removes and returns the item at the front of the deque. If no such item
     * exists, return null
     */
    public T removeFirst();

    /** Removes and returns the item at the back of the deque. If no such item
     * exists, return null
     */
    public T removeLast();

    /** Get the item at the given index. If no such item exists, return null */
    public T get(int index);
}
