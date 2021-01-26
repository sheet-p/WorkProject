//Given two sequences, find the length of longest common substring present in both of them.
//A substring is a sequence that appears contiguous.

public class BottomUpLCSubstring {
    public static void main(String[] args) {
        String a="abcde", b="abxcydef";
        System.out.println(longest(a, b, a.length(), b.length()));
    }

    private static int longest(String a, String b, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int result = 1;
        //base conditions
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        //choice diagram conditions
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }

        return result;
    }
}
