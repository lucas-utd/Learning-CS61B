
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }

//    public boolean isPalindrome(String word) {
//        int start = 0, end = word.length() - 1;
//        while (start < end) {
//            if (!equalChars(word.charAt(start), word.charAt(end))) {
//                return false;
//            }
//            start += 1;
//            end -= 1;
//        }
//        return true;
//    }
}
