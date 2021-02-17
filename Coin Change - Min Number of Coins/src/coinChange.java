//Given a value V, if we want to make change for V cents, and we have infinite supply of each of
// C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
//Example:
//
//Input: coins[] = {25, 10, 5}, V = 30
//Output: Minimum 2 coins required
//We can use one coin of 25 cents and one of 5 cents
//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class coinChange {
    public static void main(String[] args) {
        int coin[]={1,2,3}, N=5;
        System.out.println(change(coin, coin.length, N));
    }

    private static int change(int[] coin, int n, int sum) {
        int[][] memo = new int[n+1][sum+1];

        //initialization
        for(int i=0; i<=sum; i++) {
            memo[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=1; i<=n; i++)
            memo[i][0] = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(coin[i-1] <= j) {
                    memo[i][j] = Math.min(1+memo[i][j-coin[i-1]], memo[i-1][j]);
                }
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        return memo[n][sum] >= Integer.MAX_VALUE ? -1 : memo[n][sum];
    }
}
