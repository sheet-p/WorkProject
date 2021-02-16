// Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
// Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
//Example:
//if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable
// value is 22 (by cutting in two pieces of lengths 2 and 6)
//
//
//length   | 1   2   3   4   5   6   7   8
//--------------------------------------------
//price    | 1   5   8   9  10  17  17  20
public class RodCutting {
    public static void main(String[] args) {
        int n=8, length[]={1,2,3,4,5,6,7,8}, price[]={1,5,8,9,10,17,17,20};
        System.out.println(knapsack(price, n, n-2));
    }

    private static int knapsack(int[] price, int length_rod, int n) {
        if(n == 0)
            return 0;
        int val = price[n] + price[(length_rod - (n+1))-1];
        return Math.max(val, knapsack(price, length_rod, n-1));
    }
}
