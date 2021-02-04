import java.util.HashMap;
import java.util.Map;

public class Reorganize {
    public static void main(String[] args) {
        String S = "aabb";
        if (S == null || S.length() == 1)
            System.out.println(S);

        Map<Character, Integer> dic = new HashMap<>();
        char maxChar = S.charAt(0);
        int L = S.length();

        // count chars in map, get max
        for (char c: S.toCharArray()) {
            dic.put(c, dic.getOrDefault(c, 0) +1);
            if (dic.get(c) > dic.get(maxChar)) {
                maxChar = c;
            }
        }

        if (dic.get(maxChar) > (L+1)/2)
            System.out.println("");

        int idx = 0;
        char[] ret = new char[L];

        // put all maxChar's into array (may not reach end of S)
        while (idx < L && dic.get(maxChar) > 0) {
            ret[idx] = maxChar;
            dic.put(maxChar, dic.get(maxChar)-1);
            idx +=2;
        }

        // loop through dic, may go through a key where val is 0, but won't do anything
        for (Character c: dic.keySet()) {
            while (dic.get(c) > 0) {
                if (idx >= L) idx = 1; // First time it reaches L, reset it. Won't be inf loop cause not looping on idx
                ret[idx] = c;
                dic.put(c, dic.get(c)-1);
                idx += 2;
            }
        }
        System.out.println(new String(ret));
    }
}
