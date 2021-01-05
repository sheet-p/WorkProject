import java.util.Arrays;

public class Knapsack {
    /* This is a 0-1 Knapsack problem. We are given a knapsack and its total weight capacity. We need to figure the
    number of items to be put into this knapsack so that the profit is maximised. As input, we will be given the total
     weight capacity of the knapsack, the weights of individual items, the value of those individual items.
     */
    public static void main(String[] args) {
        int weight[] ={1, 3, 4, 5}, val[]= {1, 4, 5, 7}, W = 7;
        int len = val.length;
        System.out.println(knapsack(weight, val, W, len-1));
    }

    public static int knapsack(int[] weight, int[] val, int W, int len) {
        int maxPrice[][] = new int [len+1][W];
        //Arrays.fill(maxPrice, -1);
        if(len==0 || W==0)
            return 0;
        if(maxPrice[len][W] != 0)
            return maxPrice[len][W];
        if(val[len-1] > W) {
            return maxPrice[len][W] = knapsack(weight, val, W, len-1);
        }
        return maxPrice[len][W] = Math.max(val[len-1] + knapsack(weight, val, W-val[len-1], len-1) ,
                                                    knapsack(weight, val, W, len-1))  ;


    }
}
