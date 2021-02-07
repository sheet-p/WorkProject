import java.util.Scanner;
/* We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string that denotes a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.
https://www.hackerrank.com/challenges/ctci-contacts/problem */
public class Contacts {
    private static Trie root;

    Contacts() {
        root = new Trie();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        //accepting commands
        for(int i=0; i<n; i++) {
            String strt = input.nextLine();
            String[] str = strt.split(" ");
            String op = str[0];
            String name = str[1];

            if(op.equals("add"))
                insert(name);
            else {
                int freq = search(name);
                if(freq == Integer.MAX_VALUE)
                    System.out.println("0");
                else
                    System.out.println(freq);
            }
        }
    }

    public static void insert(String word) {
        Trie current = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            Trie node = current.children.get(ch);
            if(node == null) {
                node = new Trie();
                node.words ++;
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public static int search(String word) {
        Trie current = root;
        int freq = Integer.MAX_VALUE, i=0;
        for(i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            Trie node = current.children.get(ch);
            if(node == null)
                break;
            else
                freq = Math.min(freq, node.words);
        }
        return freq;
    }
}
