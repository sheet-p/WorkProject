//The maximum subarray problem is the task of finding the largest possible sum of a contiguous subarray, within a given one-dimensional array
//https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d

//brute force
//1. find local max for each and store in an array
//2. find max of all those local max

//in Kadane's algo
//local max[i] = Maximum(A[i], A[i] + local max[i-1])

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int local_max = 0, global_max=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            local_max = Math.max(arr[i], local_max + arr[i]);

            global_max = Math.max(global_max, local_max);
        }

        System.out.println("Maximum Sum of Contigous Subarray : " + global_max);
    }
}
