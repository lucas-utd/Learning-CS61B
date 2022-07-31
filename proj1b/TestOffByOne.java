import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void equalCharsTest() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }

//    public void testIsPalindrome() {
//        OffByOne offByOne1 = new OffByOne();
//        assertTrue(offByOne1.isPalindrome("aba"));
//        assertTrue(offByOne1.isPalindrome("abba"));
//        assertTrue(offByOne1.isPalindrome(""));
//        assertTrue(offByOne1.isPalindrome("a"));
//
//        assertFalse(offByOne1.isPalindrome("ab"));
//        assertFalse(offByOne1.isPalindrome("acb"));
//    }
}
