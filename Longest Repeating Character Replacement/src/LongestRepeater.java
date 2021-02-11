//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeater {
    public static void main(String[] args) {
        String s="ABCCBCA";
        int k=1;

        int left=0, right=0, curr_count=0, max_count=0, maxLen=0;
        int[] char_count = new int[26];

        for(right=0; right<s.length(); right++) {
            char_count[s.charAt(right) - 'A']++;
            curr_count = char_count[s.charAt(right) - 'A'];

            //freq of the maximum repeating character until now
            max_count = Math.max(max_count, curr_count);

            //right-left+1 will give the current window size
            //max will give count of the same charcetrs in this windows
            //so difference of both will give the numbeer of different characters in this window and it should be <=k
            if(right-left+1 - max_count > k) {
                char_count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        System.out.println(maxLen);
    }
}
