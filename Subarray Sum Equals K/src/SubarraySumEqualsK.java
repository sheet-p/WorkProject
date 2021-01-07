import java.util.HashMap;
import java.util.Map;
//Leetcode 560
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k=2, runningSum = 0, counter = 0;
        if(nums.length == 0)
            System.out.println("0");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int curr : nums) {
            runningSum += curr;
            if(map.containsKey(runningSum - k))
                counter += map.get(runningSum - k);
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }
        System.out.println(counter);
    }
}
