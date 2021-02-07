import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<Character, Trie> children;
    int words;
    boolean endOfWord;

    public Trie() {
        children = new HashMap<>();
        words = 0;
        endOfWord = false;
    }
}
