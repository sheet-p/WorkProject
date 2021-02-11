import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSub {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        //storing characters and their positions
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = Integer.MIN_VALUE;

        while(right < s.length()) {
            map.put(s.charAt(right), right++);
            if(map.size() > k) {
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index+1;
            }
            max = Math.max(max, right-left);
        }

        return max;
    }
}
