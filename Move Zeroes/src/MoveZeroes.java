//move all zeroes to the right while maintaining relative positioning of the non-zero elements
public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = {0,1,0,0,3,0,12};

        int lastnonzero = 0, curr=0;

        for(curr=0; curr<arr.length; curr++) {
            if(arr[curr] != 0) {
                int temp = arr[curr];
                arr[curr] = arr[lastnonzero];
                arr[lastnonzero++] = temp;
            }
        }
    }
}
