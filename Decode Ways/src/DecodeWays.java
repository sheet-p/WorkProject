import java.util.Arrays;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    //for memoization
    static int[] memo;
    public static void main(String[] args) {
        String s = "22";
        int n = s.length();
        memo = new int[n + 1];
        Arrays.fill(memo,-1);

        if(s==null || s.length()==0) {
            System.out.println("0");
            System.exit(1);
        }
        else {
            System.out.println(decode(s, 0));
        }
    }

    private static int decode(String s, int index) {
        if(index==s.length() || index==s.length()-1)
            return 1;

        //if it starts with 0 (eg. 06) then its invalid
        if(s.charAt(index) == '0')
            return 0;

        if(memo[index] != -1)
            return memo[index];

        //it can either be decoded by one char or 2 characters if both characters come upto less than 26
        //eg 112 -> 1+decode(12) or 11+decode(2)
        //eg 272 -> 2+decode(72)
        int result = decode(s, index+1);
        if(Integer.parseInt(s.substring(index, index+2)) <= 26)
            result += decode(s, index+2);

        memo[index]=result;
        return result;
    }
}
