import java.util.HashSet;
import java.util.Set;

/* Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9. */
public class SubsetSum {
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2}, sum = 9;
        int len = set.length;
        System.out.println(knapsack(set, sum, len-1));
    }

    private static boolean knapsack(int[] set, int sum, int n) {
        boolean[][] memo = new boolean[n+1][sum+1];
        //initialization
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            memo[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            memo[i][0] = false;

        //choice diagram conditions
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(set[i-1] <= j)
                    memo[i][j] = memo[i-1][j - set[i-1]] || memo[i-1][j];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        return memo[n][sum];
    }
}
