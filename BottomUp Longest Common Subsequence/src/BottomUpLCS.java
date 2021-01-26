//Given two sequences, find the length of longest subsequence present in both of them.
//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//
//For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
public class BottomUpLCS {
    public static void main(String[] args) {
        String x = "abcdefgh", y="abcryghjk";
        System.out.println(longest(x,y,x.length(), y.length()));
    }

    private static int longest(String x, String y, int m, int n) {
        int[][] dp = new int[m+1][n+1];
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
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
