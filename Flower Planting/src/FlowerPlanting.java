import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlanting {
    public static void main(String[] args) {
        int n=3, paths[][] = {{1,2}, {2,3}, {3,1}};
        int[] res = gardenNoAdj(n, paths);
        for(int elem : res)
            System.out.println(elem);
    }

    private static int[] gardenNoAdj(int n, int[][] paths) {
        //create a graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++)
            graph.put(i, new HashSet<>());

        for(int[] path : paths) {
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }

        //solution
        int[] result = new int[n];

        //foreach garden
        for(int i=0; i<n; i++) {
            int[] flowers = new int[5];             //extra 1 to use 1 based indexing
            for(int neighbor : graph.get(i)) {
                flowers[result[neighbor]] = 1;      //marking the color as used for all neighbors
            }

            //now use a flower that hasn't been used
            for (int c = 4; c >= 1; c--){
                if (flowers[c] != 1) //colors[c] == 0 => the color has not been used yet,
                    result[i] = c; //so let's use that one
            }
        }

        return result;
    }
}
