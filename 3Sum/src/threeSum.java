import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.*/
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = three(nums);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> three(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> temp = twoSum(nums, i);
            if(temp != null) {
                res = temp;
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int pos) {
        //add all to map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(pos != i)
                map.put(nums[i], i);
        }

        int a = nums[pos];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(i==pos)
                continue;
            int complement = -(a + nums[i]);
            if(map.containsKey(complement)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(complement);
                temp.add(a);
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
