//Matrix Chain Multiplication using Recursion
// Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem
// is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MCM {
    public static void main(String[] args) {
        int[] arr  = {1, 2, 3, 4, 3};
        if(arr==null || arr.length==0)
            System.out.println("0");
        System.out.println(mcmRecur(arr,1,arr.length-1));
    }

    private static int mcmRecur(int[] arr, int i, int j) {
        if(i >= j)
            return 0;
        int result = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int temp = mcmRecur(arr,i,k) + mcmRecur(arr,k+1,j) + (arr[i-1] * arr[k] * arr[j]);
        result = Math.min(result, temp);

        }

        return result;
    }
}
