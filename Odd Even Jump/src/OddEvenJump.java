import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/odd-even-jump/
public class OddEvenJump {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int n = arr.length;
        if(n <= 1 || arr==null) {
            System.out.println("0");
            System.exit(1);
        }
        else {
            System.out.println(jump(arr));
        }
    }

    private static int jump(int[] arr) {
        int n = arr.length;

        //to keep track of whether the odd/even jumps are possible from this index
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        //jump from last is anyways true for both
        odd[n-1] = even[n-1] = true;

        //DS used
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);

        for(int i=n-2; i>=0; i--) {
            int val = arr[i];

            //odd/even jump is already calculated
            if(map.containsKey(val)) {
                odd[i] = even[map.get(val)];
                even[i] = odd[map.get(val)];
            }
            else {
                Integer lower = map.lowerKey(val);
                Integer higher = map.higherKey(val);

                if(lower != null)
                    even[i] = odd[map.get(lower)];
                if(higher != null)
                    odd[i] = even[map.get(higher)];
            }
            map.put(val, i);
        }

        int jumps = 0;
        //loop through odd array to find number of 'true' coz from these jumps will be possible
        for(boolean b : odd)
            jumps += b==true ? 1 : 0;

        return jumps;
    }
}
