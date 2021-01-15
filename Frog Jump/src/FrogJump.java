import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//  LeetCode 403
public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
    private static boolean canCross(int[] stones) {
        //check to see if they're too far away
        for(int i=3; i<stones.length; i++)
            if(stones[i] > stones[i-1]*2)
                return false;

        //record stone positions
        Set<Integer> stonePositions = new HashSet<>();
        for(int stone : stones)
            stonePositions.add(stone);
        //recording our positions
        Stack<Integer> positions = new Stack<>();
        //recording jumps
        Stack<Integer> jumps = new Stack<>();
        int lastStone = stones[stones.length - 1];
        positions.add(0);
        jumps.add(0);
        while(! positions.isEmpty()) {
            int curr = positions.pop();
            int prevJump = jumps.pop();
            for(int i=prevJump-1; i<=prevJump+1; i++) {
                if(i <= 0)
                    continue;
                int nextPosition = curr + i;
                if(nextPosition == lastStone)
                    return true;
                else if(stonePositions.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}
