import java.util.HashMap;
import java.util.Map;

public class Trie {
    boolean endOfWord;
    Trie children[];

    Trie() {
        children = new Trie[26];
        endOfWord = false;
    }
}
