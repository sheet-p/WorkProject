import java.util.HashMap;
import java.util.Map;

public class Trie {
    boolean endOfWord;
    Trie children[];

    Trie() {
        for(int i=0; i<26; i++) {
            this.children[i] = new Trie();
        }
        endOfWord = false;
    }
}
