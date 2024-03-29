
public class LinkedListDeque<T> implements Deque<T> {

    private static class Node<T> {
        public Node<T> prev, next;
        public T item;

        public Node(T input) {
            this(input, null, null);
        }

        public Node(T input, Node<T> prev, Node<T> next) {
           this.item = input;
           this.prev = prev;
           this.next = next;
        }
    }

    private final Node<T> sentinel;

    private int length;

    public LinkedListDeque() {
        Node<T> tmp = new Node<>(null);
        tmp.prev = tmp.next = tmp;
        sentinel = tmp;
    }

    @SafeVarargs
    public static <S> LinkedListDeque<S> of(S... args) {
        LinkedListDeque<S> result;
        Node<S> p;

        if (args.length > 0) {
            result = new LinkedListDeque<S>();
        } else {
            return null;
        }

        int k;
        for (k = 0, p = result.sentinel; k < args.length; k += 1, p = p.next) {
            Node<S> newNode = new Node<>(args[k], p, p.next);
            p.next.prev = newNode;
            p.next = newNode;
        }
        result.length = args.length;

        return result;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        length += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        length += 1;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String printDeque() {
        StringBuffer sb = new StringBuffer();
        Node<T> p = sentinel.next;
        if (p != sentinel) {
            sb.append(p.item);
            p = p.next;
        }
        while (p != sentinel) {
            sb.append(" ");
            sb.append(p.item);
            p = p.next;
        }

        return sb.toString();
    }

    @Override
    public T removeFirst() {
        if (length == 0) {
            return null;
        }
        Node<T> firstNode = sentinel.next;
        firstNode.next.prev = sentinel;
        sentinel.next = firstNode.next;

        length -= 1;

        return firstNode.item;
    }

    @Override
    public T removeLast() {
        if (length == 0) {
            return null;
        }
        Node<T> lastNode = sentinel.prev;
        lastNode.prev.next = sentinel;
        sentinel.prev = lastNode.prev;

        length -= 1;

        return lastNode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length)
        {
            return null;
        }
        int cur = -1;
        Node<T> p = sentinel;
        while (cur < index) {
           p = p.next;
           cur += 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        return helperRecursive(index, sentinel.next);
    }

    private T helperRecursive(int index, Node<T> p) {
        if (index == 0) {
            return p.item;
        }
        return helperRecursive(index - 1, p.next);
    }
}
