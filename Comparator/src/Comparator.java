import java.util.PriorityQueue;

public class Comparator {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new java.util.Comparator<Integer>() {

            //priority queue will have integers sorted from -1 to 1
            @Override
            public int compare(Integer lhs, Integer rhs) {
                if(lhs < rhs)
                    return 1;
                else if(lhs > rhs)
                    return -1;
                else
                    return 0;
            }
        });

        pq.add(3);
        pq.add(2);
        pq.add(6);
        pq.add(5);
        pq.add(1);

        System.out.println(pq);
        while(! pq.isEmpty())
            System.out.println(pq.poll());
    }
}
