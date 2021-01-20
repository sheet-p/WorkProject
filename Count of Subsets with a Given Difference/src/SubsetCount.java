/* Given a difference, return the count of total number of subsets which satisfy this.
Example : arr[] = 1,1,2,3 and diff=1
                  1 --> (1,3) and (1,2)
                  2 --> (1,1,2) and (3)
                  3 --> (1,3) and (1,2)
                  answer = 3

           sum(S1) - sum(S2) = diff
           sum(S1) + sum(S2) = sum(arr)

           2Sum(S1) = diff + sum(arr)
           sum(s1) = 1\2 (diff + sum(arr) )

           sum(S1) = 1/2(1 + 7) = 4
           Count the number of subsets whose sum is 4
 */
public class SubsetCount {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3}, diff = 1;
        if(arr == null || arr.length==0) {
            System.out.println("0");
            System.exit(0);
        }
        int sum = 0;
        for(int i=0; i<arr.length; i++)
            sum += arr[i];
        sum = (int) ((diff + sum) * 0.5);
        System.out.println(knapsack(arr, sum, arr.length));
    }

    private static int knapsack(int[] arr, int sum, int n) {
        int[][] memo = new int[n+1][sum+1];

        //if length=0 then count = 0
        for(int i=0; i<sum+1; i++)
            memo[0][i] = 0;
        //if sum=0 then count = 1 coz of nullsets
        for(int i=0; i<n+1; i++)
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
