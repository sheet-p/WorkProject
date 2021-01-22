import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CombSum {
    public static void main(String[] args) {
        int arr[] = {2,3,6,7}, target = 7;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        result = backtrack(arr, target, result, 0, new ArrayList<>());
        for(List<Integer> list : result) {
            for(Integer elem : list)
                System.out.println(elem);
        }
    }

    private static List<List<Integer>> backtrack(int[] arr, int target, List<List<Integer>> result, int start, List<Integer> temp) {
        if (target == 0)
            result.add(temp);
        if(target < 0) {
            return null;
        }
        for(int i=start; i<arr.length; i++) {
            temp.add(arr[i]);
            backtrack(arr, target - arr[i], result, start, temp);
            temp.remove(temp.size()-1);
        }

        return result;
    }
}
