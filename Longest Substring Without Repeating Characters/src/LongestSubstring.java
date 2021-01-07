import java.util.ArrayList;
import java.util.List;

//LeetCode 3
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        List<Character> unique = new ArrayList<>();
        int[] visited = new int[s.length()];
        int loop, max=0, count=0, inner=0;
        if(s == null)
            System.out.println("0");
        for(loop=0; loop<s.length(); loop++) {
            if(!(unique.contains(s.charAt(loop)))) {
                unique.add(s.charAt(loop));
                //visited[loop] = 0;
                max = Math.max(max, unique.size());
            }
            else {
                inner = unique.lastIndexOf(s.charAt(loop));
                while(inner >= 0) {
                    unique.remove(unique.get(inner));
                    inner--;
                }
                unique.add(s.charAt(loop));
            }
        }
        System.out.println(max);
    }
}
