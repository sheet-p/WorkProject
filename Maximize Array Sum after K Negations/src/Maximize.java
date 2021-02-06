//Given an array of size n and a number k. We must modify array K number of times. Here modify
// array means in each operation we can replace any array element arr[i] by -arr[i]. We need to
// perform this operation in such a way that after K operations, sum of array must be maximum

import java.util.PriorityQueue;

public class Maximize {
    public static void main(String[] args) {
        int arr[] = {-2, 0, 5, 2, -1}, K=4;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //adding elem into pq
        for(int elem : arr)
            pq.add(elem);

        while (K > 0) {
            int elem = pq.poll();

            elem = 1 * -(elem);

            pq.add(elem);
            K--;
        }

        int sum = 0;
        while(! pq.isEmpty())
            sum += pq.poll();

        System.out.println(sum);
    }
}
