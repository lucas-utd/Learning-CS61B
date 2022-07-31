import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void printDequeTest() {
        ArrayDeque<Integer> deque = ArrayDeque.of(4, 2, 3);
        assert deque != null;
        assertEquals("4 2 3", deque.printDeque());
    }

    @Test
    public void ofTest() {
        ArrayDeque<Integer> deque = ArrayDeque.of();
        assertNull(deque);

        ArrayDeque<Integer> deque1 = ArrayDeque.of(1, 2, 3);
        assertNotNull(deque1);
        assertEquals("1 2 3", deque1.printDeque());

        ArrayDeque<Integer> deque2 = ArrayDeque.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertNotNull(deque1);
        assertEquals("1 2 3 4 5 6 7 8 9", deque2.printDeque());
    }

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals("2 1", deque.printDeque());

        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        for (int i = 1; i < 10; i += 1) {
            deque1.addFirst(i);
        }
        assertEquals("9 8 7 6 5 4 3 2 1", deque1.printDeque());
    }

    @Test
    public void addLastTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals("1 2 3", deque.printDeque());

        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        for (int i = 1; i < 10; i += 1) {
            deque1.addLast(i);
        }
        assertEquals("1 2 3 4 5 6 7 8 9", deque1.printDeque());
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.isEmpty());

        deque.addFirst(1);
        assertFalse(deque.isEmpty());

        ArrayDeque<Integer> deque1 = ArrayDeque.of(1, 2, 3);
        assert deque1 != null;
        assertFalse(deque1.isEmpty());
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull(deque.removeFirst());

        deque.addFirst(1);
        assertEquals(Integer.valueOf(1), deque.removeFirst());

        ArrayDeque<Integer> deque1 = ArrayDeque.of(3, 2, 1);
        assert deque1 != null;
        assertEquals(Integer.valueOf(3), deque1.removeFirst());
        assertEquals("2 1", deque1.printDeque());
        assertEquals(2, deque1.size());

        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        for (int i = 1; i <= 1000; i += 1) {
            deque2.addFirst(i);
        }
        int k = 984;
        while (k > 0) {
            deque2.removeFirst();
            k -= 1;
            assertTrue((deque2.size() * 1.0 / deque2.memorySize()) >= 0.25);
        }

        ArrayDeque<Integer> deque3 = new ArrayDeque<>();
        for (int i = 1; i <= 1000; i += 1) {
            deque3.addFirst(i);
        }
        int m = 1000;
        while (m > 0) {
            deque3.removeFirst();
            m -= 1;
        }
        deque3.addFirst(1);
        deque3.addFirst(2);
        assertEquals(Integer.valueOf(2), deque3.removeFirst());
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull(deque.removeLast());

        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(Integer.valueOf(1), deque.removeLast());

        ArrayDeque<Integer> deque1 = ArrayDeque.of(3, 2, 1);
        assert deque1 != null;
        assertEquals(Integer.valueOf(1), deque1.removeLast());
        assertEquals("3 2", deque1.printDeque());
        assertEquals(2, deque1.size());

        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        for (int i = 1; i <= 1000; i += 1) {
            deque2.addLast(i);
        }
        int k = 984;
        while (k > 0) {
            deque2.removeLast();
            k -= 1;
            assertTrue((deque2.size() * 1.0 / deque2.memorySize()) >= 0.25);
        }

        ArrayDeque<Integer> deque3 = new ArrayDeque<>();
        for (int i = 1; i <= 1000; i += 1) {
            deque3.addLast(i);
        }
        int m = 1000;
        while (m > 0) {
            deque3.removeLast();
            m -= 1;
        }
        deque3.addFirst(1);
        deque3.addFirst(2);
        assertEquals(Integer.valueOf(1), deque3.removeLast());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertNull(deque.get(0));

        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals(Integer.valueOf(2), deque.get(0));
        assertEquals(Integer.valueOf(1), deque.get(1));
        assertNull(deque.get(2));

        ArrayDeque<Integer> deque1 = ArrayDeque.of(3, 2, 1);
        assert deque1 != null;
        assertEquals(Integer.valueOf(1), deque1.get(2));
        assertEquals(Integer.valueOf(2), deque1.get(1));
        assertEquals(Integer.valueOf(3), deque1.get(0));
    }
}
