import java.util.HashMap;
import java.util.Map;

public class FruitBaskets {
    public static void main(String[] args) {
        int[] tree = new int[]{0, 1, 2, 2};
        if(tree.length==0 || tree==null)
            System.out.println("0");
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 1;
        while(j < tree.length) {
            if(map.size() <= 2) {
                map.put(tree[j], j++);
            }

            if(map.size() > 2) {
                int min = Integer.MAX_VALUE;
                //find the lastIndexOf first type of fruit
                for(int val : map.values()) {
                    min = Math.min(min, val);
                }
                i = min + 1;
                map.remove(tree[min]);
            }

            max = Math.max(max, j-i);
        }
        System.out.println(max);
    }
}
