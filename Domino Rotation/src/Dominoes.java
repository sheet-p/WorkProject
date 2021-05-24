import java.util.HashMap;
import java.util.Map;

public class Dominoes {
    public static void main(String[] args) {
        int top[]={3,5,1,2,3}, bottom[]={3,6,3,3,4};
        int max = -1;
        boolean flag = false;

        //frequency table
        Map<Integer, Integer> freqT = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();
        for(int i=0; i<top.length; i++) {
            freqT.put(top[i], freqT.getOrDefault(top[i], 0)+1);
        }
        for(int i=0; i<top.length; i++) {
            freqB.put(top[i], freqB.getOrDefault(top[i], 0)+1);
        }

        //finding maximum repeated key
        if(freqT.size() < freqB.size()) {
            max = findMax(freqT);
            flag = true;
            System.out.println(flip(max, top, bottom));
        }
        else {
            max = findMax(freqB);
            System.out.println(flip(max, bottom, top));
        }

    }

    private static int findMax(Map<Integer, Integer> freq) {
        int maxV = Integer.MIN_VALUE, maxK = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> map : freq.entrySet()) {
            if(map.getValue() > maxV) {
                maxV = map.getValue();
                maxK = map.getKey();
            }
        }

        return maxK;
    }

    private static int flip(int max, int[] arr, int[] flip) {
        int flips = 0;
        //flipping the arrays
        for(int i=0; i<arr.length; i++) {
            if(flip[i] != max) {
                flip[i] = arr[i];
                flips++;
            }
        }

        //check if flipped array contains all equal numbers
        for(int i=0; i<flip.length; i++) {
            if (flip[i] != max)
                return -1;
        }
        return flips;
    }
}
