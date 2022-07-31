import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {

    @Test
    public void equalCharsTest() {
        OffByN offByN = new OffByN(2);
        assertTrue(offByN.equalChars('a', 'c'));
        assertTrue(offByN.equalChars('r', 't'));
        assertTrue(offByN.equalChars('1', '3'));

        assertFalse(offByN.equalChars('a', 'a'));
        assertFalse(offByN.equalChars('a', 'b'));
        assertFalse(offByN.equalChars('1', '2'));
    }
}
