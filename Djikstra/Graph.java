import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    public void shortestPath(int[][] distances, int src, int nodes) {
        int[] d = new int[nodes];
        int min = 0, k=0, i=0;
        Arrays.fill(d, Integer.MAX_VALUE);

        d[src] = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        while(visited.size() < nodes) {
            int minDist = minDistance(d, visited, nodes);
            visited.add(minDist);
            //checking all adjacent vertices of minDist
            for(i=0; i<nodes; i++) {
                if(!visited.contains(i) && distances[minDist][i]!=0 && d[i]>d[minDist]+distances[minDist][i]) {
                    d[i] = d[minDist] + distances[minDist][i];
                }
            }
        }
        printDistance(d, nodes);
    }

    public int minDistance(int[] d, ArrayList<Integer> visited, int n) {
        int min = Integer.MAX_VALUE, k=0;
        for(int i=0; i<d.length; i++) {
            if(visited.get(i) != i && d[i]<min) {
                min = i;
            }
        }
        return min;
    }

    public void printDistance(int[] d, int nodes) {
        for(int i=0; i<nodes; i++)
            System.out.println(i + " -> " + d[i]);
    }
}