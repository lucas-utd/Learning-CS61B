public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }
        LinkedListDeque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> newWord = wordToDeque(word);
        while (newWord.size() >= 2) {
            if (!newWord.removeFirst().equals(newWord.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int start = 0, end = word.length() - 1;
        while (start < end) {
            if (!cc.equalChars(word.charAt(start), word.charAt(end))) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
}
