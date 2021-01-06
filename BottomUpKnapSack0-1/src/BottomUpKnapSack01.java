public class BottomUpKnapSack01 {
    /* This is a 0-1 Knapsack problem. We are given a knapsack and its total weight capacity. We need to figure the
    number of items to be put into this knapsack so that the profit is maximised. As input, we will be given the total
     weight capacity of the knapsack, the weights of individual items, the value of those individual items.
     */
    public static void main(String[] args) {
        int weight[] ={1, 3, 4, 5}, val[]= {1, 4, 5, 7}, W = 7;
        int len = val.length;
        int max = knapsack(weight, val, W, len);
        System.out.println(max);
    }

    public static int knapsack(int[] weight, int[] val, int W, int len) {
        int[][] memo = new int[len+1][W+1];
        int i=0, j=0;
        //base condition
        for(i=0; i<len+1; i++) {
            for(j=0; j< W+1; j++) {
                if(i==0 || j==0)
                    memo[i][j] = 0;
            }
        }

        //choice diagram conditions
        for(i=1; i<=len; i++) {
            for(j=1; j<=W; j++) {
                if(weight[i-1]<=j)
                    memo[i][j] = Math.max(val[i-1] + memo[i-1][j-weight[i-1]], memo[i-1][j]);

                else {
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        return memo[len][W];
    }
}
