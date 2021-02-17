//Given a value N, if we want to make change for N cents, and we have infinite supply of each of
// S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//Example:
//for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
public class CoinChange {
    public static void main(String[] args) {
        int coin[]={1,2,3}, N=5;
        System.out.println(change(coin, coin.length, N));
    }

    private static int change(int[] coin, int n, int sum) {
        if(sum==0)
            return 1;
        if(sum < 0)
            return 0;
        if(n<=0 && sum>=1)
            return 0;
        //either include it or you dont
        return change(coin, n, sum-coin[n-1]) + change(coin, n-1, sum);
    }
}
