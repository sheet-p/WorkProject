//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        int towers[]={1,1,2,2,0,1,1};
        if(towers==null || towers.length==0)
            System.out.println("False");
        else {
            int goal = towers.length-1;
            for(int i=goal-1; i>=0; i--) {
                if(i+towers[i] >= goal)
                    goal = i;
            }
            System.out.println(goal<=0);
        }
    }
}