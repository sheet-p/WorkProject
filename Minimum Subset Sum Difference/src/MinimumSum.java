/*Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference
 between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the
 value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:
Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11 */

import java.util.ArrayList;
import java.util.List;

public class MinimumSum {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5}, range=0;
        //to find range, find sum of arr
        for(int i=0; i<arr.length; i++)
            range += arr[i];
        //nums contain numbers in the range which are actually possible
        ArrayList<Integer> nums = subsetSum(arr, range, arr.length);

        //finding minimum
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++)
            min = Math.min(min, range-2*nums.get(i));

        System.out.println(min);
    }

    private static ArrayList<Integer> subsetSum(int[] arr, int range, int n) {
        boolean[][] memo = new boolean[n+1][range+1];
        ArrayList<Integer> nums = new ArrayList<>();

        //initialization
        // If sum is 0, then answer is true
        for (int i = 0; i <= range; i++)
            memo[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= n; i++)
            memo[i][0] = false;

        //choice diagram conditions
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<range+1; j++) {
                if(arr[i-1] <= j)
                    memo[i][j] = memo[i-1][j - arr[i-1]] || memo[i-1][j];
                else
                    memo[i][j] = memo[i-1][j];
            }
        }

        for(int i=0; i<(range+1)/2; i++)
            if(memo[n][i])
                nums.add(i);
        return nums;
    }
}
