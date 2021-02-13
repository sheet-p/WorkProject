import java.util.HashSet;
import java.util.Set;

public class SubArrayK {
    public static void main(String[] args) {
        int[] A={1,2,1,2,1,2,3};
        int K=2;
        int left=0, right = 0, subNum=0;
        Set<Integer> count = new HashSet<>();

        while(right < A.length) {
            count.add(A[right]);

            if(count.size() > K) {
                count.clear();
                left++;
                right = left;
            }

            else if(count.size() == K) {
                subNum++;
                right++;
                if(right == A.length) {
                    left++;
                    right = left;
                    count.clear();
                }
                else
                    right++;
            }
        }
        System.out.println(subNum);
    }
}
