/*Equal Sum Partition Problem
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11} */
public class EqualSumPartition {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5}, sum = 0;
        for(int i=0; i<arr.length; i++)
            sum += arr[i];
        /*arr can be partitioned into two only if sum is even
            sum of partition 1 = S
            sum of partition 2 = S
            sum of full arr = 2S (which is even)  */
        if(sum % 2 != 0)
            System.out.println("False");
        else
            System.out.println(knapsack(arr, arr.length-1, sum/2));
    }

    private static boolean knapsack(int[] arr, int n, int sum) {
        boolean[][] memo = new boolean[n+1][sum+1];
        for(int j=0; j<sum+1; j++)
            memo[0][j] = false;
        for(int i=0; i<n+1; i++)
            memo[i][0] = true;

        //choice diagram conditions
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1] <= j)
                    memo[i][j] = memo[i-1][j-arr[i-1]] || memo[i-1][j];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        return memo[n][sum];
    }
}
