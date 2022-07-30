
public class ArrayDeque<T> implements Deque<T> {
    // Points to the first item
    private int start;
    // Points to the next available position
    private int end;
    private T[] items;

    public ArrayDeque() {
        start = end = 0;
        items = (T[]) new Object[8];
    }

    public static <S> ArrayDeque<S> of(S... args) {
        ArrayDeque<S> result;

        if (args.length > 0) {
            result = new ArrayDeque<>();
            if (args.length > result.items.length) {
                result.items = (S[]) new Object[args.length];
            }
        } else {
            return null;
        }

        System.arraycopy(args, 0, result.items, 0, args.length);
        result.end = args.length;

        return result;
    }

    @Override
    public void addFirst(T item) {
        if (items.length == size()) {
            resize();
        }
        start -= 1;
        items[getIndex(start)] = item;
    }

    @Override
    public void addLast(T item) {
        if (items.length == size()) {
            resize();
        }
        items[getIndex(end)] = item;
        end += 1;
    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    @Override
    public int size() {
        return end - start;
    }

    public int memorySize() {
        return items.length;
    }

    @Override
    public String printDeque() {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (i != start) {
                sb.append(" ");
            }
            sb.append(items[getIndex(i)]);
        }
        return sb.toString();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = items[getIndex(start)];
        items[getIndex(start)] = null;
        start += 1;

        // Make the used memory meet the requirement
        shrink();

        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = items[getIndex(end - 1)];
        items[getIndex(end - 1)] = null;
        end -= 1;

        // Make the used memory meet the requirement
        shrink();

        return res;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        return items[getIndex(start + index)];
    }

    private void resize() {
        T[] tmp = (T[]) new Object[items.length * 2];
        for (int i = start, k = 0; i < end; i += 1, k += 1) {
           tmp[k] = items[getIndex(i)];
        }
        int length = size();
        start = 0;
        end = length;
        items = tmp;
    }

    private void shrink() {
        if (((end - start) * 1.0 / items.length > 0.25) || items.length < 16) {
            return;
        }

        T[] tmp = (T[]) new Object[items.length / 2];
        for (int i = start, k = 0; i < end; i += 1, k += 1) {
            tmp[k] = items[getIndex(i)];
        }
        int length = size();
        start = 0;
        end = length;
        items = tmp;
    }

    private int getIndex(int old) {
        return ((old % items.length) + items.length) % items.length;
    }
}
