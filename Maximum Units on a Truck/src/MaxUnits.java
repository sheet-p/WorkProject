import java.util.Arrays;

public class MaxUnits {
    public static void main(String[] args) {
        int[][] boxTypes = {{3,10}, {6,5}, {4,7}, {2,9}};
        int truckSize = 8;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        //counter
        int units = 0;
        for(int[] box : boxTypes) {
            int boxCount = Math.min(box[0], truckSize);
            units += boxCount * box[1];
            truckSize -= boxCount;
            if(truckSize == 0)
                break;
        }
        System.out.println(units);
    }
}
