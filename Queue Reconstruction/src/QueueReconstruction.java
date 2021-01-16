import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {
    //LeetCode 406 :You are given an array of people, people, which are the attributes of some people in a queue
    // (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly
    // ki other people in front who have a height greater than or equal to hi.
    //
    //Reconstruct and return the queue that is represented by the input array people. The returned queue should be
    // formatted as an array queue that satisfies the conditions/attributes
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        if(people==null || people.length==0 || people[0].length==0)
            System.out.println("0");
        //sort the people to make them stand from the highest to shortest. For people with same height, sort them
        // according to the count of people before them from small to big.
        Arrays.sort(people, new Comparator<int[]>()  {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });

        List<int[]> list = new LinkedList<>();
        //allocating memory
        for(int[] p : people)
            list.add(new int[2]);
        for (int[] p : people) {
            list.add(p[1], p);
        }
        System.out.println(list.toArray(new int[list.size()][]));
    }
}
