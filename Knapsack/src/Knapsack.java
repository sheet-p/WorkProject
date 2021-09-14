public class Knapsack {
    public static void main(String[] args) {
        int wt[] = {1,3,4,5}, val[] = {1,4,5,7}, W=7;

        System.out.println(helper(wt, val, W, wt.length-1));
    }

    private static int helper(int[] wt, int[] val, int W, int n) {
        //base condition
        if(W==0 || n==0)
            return 0;
        if(wt[n] <= W) {
            return Math.max(val[n] + helper(wt, val, W-wt[n], n-1), helper(wt, val, W, n-1));
        }
        else
            return helper(wt, val, W, n-1);
    }
}
