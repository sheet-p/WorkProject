import java.util.Arrays;

public class TopDown {
    //Given two sequences, find the length of longest subsequence present in both of them.
//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//
//For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.


        static int[][] memo = new int[10][10];

        public static void main(String[] args) {
            String x = "abcdefgh", y="abcryghjk";
            //inititalization of memo
            for(int[] m : memo)
                Arrays.fill(m, -1);
            System.out.println(longest(x, y, x.length()-1, y.length()-1));
        }

        private static int longest(String x, String y, int m, int n) {
            //base condition - smallest valid input
            if(n==0 || m==0)
                return 0;
            if(memo[m][n] != -1)
                return memo[m][n];
            if(x.charAt(m) == y.charAt(n)) {
                return memo[m][n] = 1+longest(x,y,m-1,n-1);
            }
            else {
                return memo[m][n] = Math.max(longest(x,y,m-1,n) , longest(x,y,m,n-1));
            }
        }


}
