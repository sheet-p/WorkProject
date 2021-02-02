//LeetCode 695 : Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded
// by water.
//
//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
public class maxAreaOfIsland {
    static int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    static boolean[][] seen;
    public static void main(String[] args) {
        if(grid==null || grid.length==0) {
            System.out.println("0");
            System.exit(0);
        }
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                ans = Math.max(ans, area(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                + area(r, c-1) + area(r, c+1));
    }
}

