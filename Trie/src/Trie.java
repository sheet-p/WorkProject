public class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    //Iterative implementation of insert
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    //Recursive Implementation of Insert
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }
    public void insertRecursive(TrieNode current, String word, int index) {
        if(index == word.length()) {
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index+1);
    }

    //Search Iterative Implementation
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            TrieNode node = current.children.get(word.charAt(i));
            if(node == null)
                return false;
            current = node;
        }
        return current.endOfWord;
    }

    //Recursive Search implementation
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }
    public boolean searchRecursive(TrieNode current, String word, int index) {
        if(index==word.length())
            return current.endOfWord;
        TrieNode node = current.children.get(word.charAt(index));
        if(node==null)
            return false;
        return searchRecursive(node, word, index+1);
    }

    public void delete(String word) {
        delete(root, word, 0);
    }
    public boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()) {
            //delete only when endOfWord if reached
            if(! current.endOfWord)
                return false;
            current.endOfWord = false;
            //if current has no other mappings then return true
            return current.children.size()==0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node==null)
            return false;
        boolean shouldDelete = delete(node, word, index+1);

        if(shouldDelete) {
            current.children.remove(ch);
            //return true if no more mappings are left
            return current.children.size()==0;
        }
        return false;
    }
}
