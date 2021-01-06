public class BottomUpKnapSack01 {
    /* This is a 0-1 Knapsack problem. We are given a knapsack and its total weight capacity. We need to figure the
    number of items to be put into this knapsack so that the profit is maximised. As input, we will be given the total
     weight capacity of the knapsack, the weights of individual items, the value of those individual items.
     */
    public static void main(String[] args) {
        int weight[] ={1, 3, 4, 5}, val[]= {1, 4, 5, 7}, W = 7;
        int len = val.length;
        System.out.println(knapsack(weight, val, W, len));
    }

    public static int knapsack(int[] weight, int[] val, int W, int len) {
        int[][] memo = new int[len+1][W+1];
        //base condition
        for(int i=0; i<len+1; i++) {
            for(int j=0; j< W+1; j++) {
                if(i==0 || j==0)
                    memo[i][j] = 0;
            }
        }

        //choice diagram conditions
        for(int i=1; i<len+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(weight[i-1]>W)
                    memo[i][j] = memo[i+1][j];
                else {
                    memo[i][j] = Math.max();
                }
            }
        }
    }
}
