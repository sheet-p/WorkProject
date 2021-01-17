import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonWord {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("\\p{Punct}"," ");
        String[] banned = {"a"};
        //splitting on any whitespace character
        String[] words = paragraph.split("\\s+");
        //frequency dictionary
        Map<String, Integer> map = new HashMap<>();
        //Set of banned words
        Set<String> ban = new HashSet<>();
        for(String word : banned)
            ban.add(word);
        //creating a frequency dictionary
        for(String word : words) {
            if(! ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        int max = 0;
        String common_word = new String();
        for(Map.Entry<String, Integer> m : map.entrySet() ) {
            if(m.getValue() > max) {
                max = m.getValue();
                common_word = m.getKey();
            }
        }

        System.out.println(common_word);
    }
}
