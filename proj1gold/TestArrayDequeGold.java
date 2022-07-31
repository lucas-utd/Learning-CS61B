import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void TestAddFirst() {
        StringBuilder sb = new StringBuilder("\n");
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                ads.addFirst(i);
                sb.append(String.format("addFirst(%s)\n", i));
            } else {
                sad1.addLast(i);
                ads.addLast(i);
                sb.append(String.format("addLast(%s)\n", i));
            }
        }

        for (int i = 0; i < 5; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer value = ads.removeFirst();
                sb.append(String.format("removeFirst(): %s\n", value));
                assertEquals(sb.toString(), sad1.removeFirst(), value);
            } else {
                Integer value = ads.removeLast();
                sb.append(String.format("removeLast(): %s\n", value));
                assertEquals(sb.toString(), sad1.removeLast(), ads.removeLast());
            }
        }
    }
}
