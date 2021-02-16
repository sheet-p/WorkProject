//Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate
// the maximum amount that could make up this quantity exactly. This is different from classical Knapsack problem,
// here we are allowed to use unlimited number of instances of an item.
// Example : Input : W = 100
//       val[]  = {1, 30}
//       wt[] = {1, 50}
//Output : 100
public class Knapsack {
    public static void main(String[] args) {
        int val[]={1,30}, wt[]={1,50}, W=100;
        System.out.println(knapsack(val, wt, W, val.length-1));
    }

    private static int knapsack(int[] val, int[] wt, int W, int n) {
        if(n==0 || W==0)
            return 0;
        if(wt[n] > W)
            return knapsack(val, wt, W, n-1);
        else {
            return Math.max((val[n] + knapsack(val, wt, W-wt[n], n)), knapsack(val, wt, W, n-1));
        }
    }
}
