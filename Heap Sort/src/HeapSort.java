//Time complexity is O(n.log n)
public class HeapSort {
    public static void main(String[] args) {
        int[] A = {2,6,4,8,1,3};
        int n = A.length;

        buildMaxHeap(A, n);

        //after building max heap we have to start deleting one by one and storing at the end
        for(int i=n-1; i>=0; i++) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;

            //reduce array length
            n = n-1;

            //make it a max heap again
            maxHeapify(A, 1, n);
        }
    }

    public static void buildMaxHeap(int[] A, int n) {
        for(int i=n/2; i>=0; i--) {
            maxHeapify(A, i, n);
        }
    }

    public static void maxHeapify(int[] A, int parent, int n) {
        int left = 2*parent, right = 2*parent + 1;
        int max = -1;

        if(left<n && A[left] > A[parent])
            max = left;
        else
            max = parent;

        if(right<n && A[right]<=A[max])
            max = right;

        if(max != parent) {
            int temp = A[parent];
            A[parent] = A[max];
            A[max] = temp;

            maxHeapify(A, max, n);
        }
    }
}
