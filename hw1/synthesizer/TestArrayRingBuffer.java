package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void enqueueTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        assertEquals(arb.capacity, 10);
        assertEquals(arb.fillCount, 1);
        assertFalse(arb.isEmpty());
        assertFalse(arb.isFull());
        assertEquals(arb.peek(), Integer.valueOf(1));

        for (int i = 2; i <= 10; i++) {
            arb.enqueue(i);
        }
    }

    @Test
    public void peekTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertNull(arb.peek());
        arb.enqueue(1);
        assertEquals(arb.peek(), Integer.valueOf(1));
    }

    @Test
    public void dequeueTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        assertEquals(arb.dequeue(), Integer.valueOf(1));
        assertTrue(arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
