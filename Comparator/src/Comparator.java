import java.util.PriorityQueue;

public class Comparator {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new java.util.Comparator<Integer>() {

            @Override
            public int compare(Integer lhs, Integer rhs) {
                if(rhs < lhs)
                    return 1;
                else if(rhs > lhs)
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
