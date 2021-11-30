import java.util.HashMap;
import java.util.Map;

public class ExpressiveWords {
    public static void main(String[] args) {
        String s= "zzzzzyyyyy", words[] = {"zzyy","zy","zyy"};

        if(s==null || s.length()==0) {
            System.exit(0);
        }
        else {
            int repetition = words(s, words);
            System.out.println(repetition);
        }
    }

    private static int words(String s, String[] words) {
        int result = 0;
        boolean flag = false;
        //hashmap for stretchy
        Map<Character, Integer> stretchy = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            stretchy.put(s.charAt(i), stretchy.getOrDefault(s.charAt(i), 0)+1);
        }

        for(String word : words) {
            flag = false;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
            }
            if(stretchy.size() == map.size()) {
                for(Map.Entry<Character,Integer> m : map.entrySet()) {
                    if(m.getValue() < stretchy.get(m.getKey()) && ( (stretchy.get(m.getKey()) - m.getValue()) >= 2) ) {
                        flag = true;
                    }
                    else if(m.getValue() == stretchy.get(m.getKey())) {
                        flag = true;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag == true)
                result++;
        }

        return result;
    }
}
