/*Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3} */

public class CountSubsets {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 10};
        int sum = 10;
        if(arr == null || arr.length == 0)
            System.out.println("0");
        System.out.println(knapsack(arr, sum, arr.length));
    }

    private static int knapsack(int[] arr, int sum, int n) {
        int[][] memo = new int[n+1][sum+1];
        //if sum = 0 then count = 1 for null subsets
        for(int i=0; i<=n; i++)
            memo[0][i] = 0;
        //if length = 0 then count = 0
        for(int i=0; i<=n; i++)
            memo[i][0] = 1;

        //choice diagram conditions
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1] <= j)
                    memo[i][j] = memo[i-1][j] + memo[i-1][j - arr[i-1]];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        return memo[n][sum];
    }
}
