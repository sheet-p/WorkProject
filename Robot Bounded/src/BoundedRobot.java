public class BoundedRobot {
    public static void main(String[] args) {
        String instructions = "GGLLGG";
        if(instructions==null || instructions.length()==0)
            System.out.println("false");
        else {
            System.out.println(isRobotBounded(instructions));
        }
    }

    private static boolean isRobotBounded(String instructions) {
        // north, east, south, west
        int[][] dirs = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        //initially facing north
        int pos = 0;
        //current positions
        int x=0, y=0;

        for(char ch : instructions.toCharArray()) {
            switch(ch) {
                case 'L':pos = (pos+3) % 4;
                case 'R':pos = (pos+1) % 4;
                default:x += dirs[pos][0];
                        y += dirs[pos][1];
            }
        }

        //robot returns to initial position or robot doesnt face north
        return ( (x==0 && y==0) || ! (pos!=0) );
    }
}
