//Matrix Chain Multiplication using Recursion
// Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem
// is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.


//Efficiently performing cost calc of matrix multiplication is as belows :
//      A1=a*b      A2=b*c
//      effective cost of A1*A2 = a*b*c


//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//LeetCode - Balloon Burst
public class MCM {
    public static void main(String[] args) {
        int[] arr  = {1, 2, 3, 4, 3};
        if(arr==null || arr.length==0)
            System.out.println("0");
        int[][] memo = new int[arr.length+1][arr.length+1];
        System.out.println(mcmMemo(memo, arr, 1, arr.length-1));
    }

    private static int mcmMemo(int[][] memo, int[] arr, int i, int j) {
        if(i >= j)
            return 0;
        if(memo[i][j] != 0)
            return memo[i][j];
        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++) {
            ans = Math.min(ans, mcmMemo(memo, arr, i, k) + mcmMemo(memo, arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]));
        }
        memo[i][j] = ans;

        return ans;
    }
}
