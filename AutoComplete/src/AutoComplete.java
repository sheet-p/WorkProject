import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoComplete {
    private static Trie root;

    AutoComplete() {
        root = new Trie();
    }

    public static void main(String[] args) {
        new AutoComplete();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter words :");
        for(int i=0; i<4; i++) {
            String word = input.nextLine();
            insert(word);
        }
        System.out.println("Enter word to be auto-completed : ");
        String str = input.nextLine();
        int comp = printSuggestions(root, str);
        if(comp < 1)
            System.out.println("No Suggestions available");
    }

    private static void insert(String word) {
        insert(root, word);
    }
    private static void insert(Trie root, String word) {
        Trie current = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            Trie node = current.children[index];
            if(node == null) {
                node = new Trie();
            }
            current = node.children[index];
        }
        current.endOfWord = true;
    }

    public static boolean isLastNode(Trie root) {
        for(int i=0; i<26; i++) {
            if(root.children[i] != null)
                return false;
        }
        return true;
    }

    public static int printSuggestions(Trie root, String prefix) {
        Trie current = root;

        //checks if prefix is present and finds node of the last character
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Trie node = current.children[ch - 'a'];
            if(node==null)
                return 0;
            current = node;
        }

        //if prefix is present as a word itself
        boolean isWord = current.endOfWord;

        //if prefix is the last node(no children
        boolean isLast = isLastNode(current);

        // If prefix is present as a word, but
        // there is no subtree below the last
        // matching node.
        if(isWord && isLast)
            return -1;

        // If there are are nodes below last
        // matching character.
        if(! isLast) {
            suggestions(current, prefix);
            return 1;
        }
        return -1;
    }

    public static void suggestions(Trie root, String prefix) {
        //if prefix is a word
        if(root.endOfWord) {
            System.out.println(prefix);
        }

        //if no children
        if(isLastNode(root))
            return ;

        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                prefix = prefix+(97+i);
                suggestions(root.children[i], prefix);
            }
        }
    }
}