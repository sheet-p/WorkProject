import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a DAG and a source vertex, find the longest distance from Source

public class LongestPath {
    public static int[] dist;

    public static void main(String[] args) {
        //                              A  B  C  E  G  H  I  J
        int graph[][] = new int[][] { { 0, 1, 0, 0, 0, 0, 0, 0 },
                                      { 0, 0, 1, 1, 0, 0, 0, 0 },
                                      { 0, 0, 0, 0, 0, 0, 0, 0 },
                                      { 0, 0, 0, 0, 1, 0, 0, 0 },
                                      { 0, 0, 0, 0, 0, 1, 0, 1 },
                                      { 0, 0, 0, 0, 0, 0, 1, 0 },
                                      { 0, 0, 0, 0, 0, 0, 0, 0 },
                                      { 0, 0, 0, 0, 0, 0, 0, 0 }};
        //initializing
        dist = new int[graph.length];
        Arrays.fill(dist, -1);

        //adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //allocate memory
        for(int i=0; i<graph.length; i++)
            adj.add(new ArrayList<>());
        adj = Adjacency(adj, graph);

        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        int longest = path(adj, visited, 0);

        System.out.println(longest);

    }

    private static ArrayList<ArrayList<Integer>> Adjacency (ArrayList<ArrayList<Integer>> adj, int[][]graph) {
        //create adjacency List
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[0].length; j++) {
                if(graph[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
        return adj;
    }

    private static int path(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        if(! visited[node]) {
            visited[node] = true;
            for(int i=0; i<adj.get(node).size(); i++) {
                int next = adj.get(node).get(i);
                dist[node] = Math.max(dist[node], 1 + path(adj, visited, next));
            }
            if(adj.get(node).size() == 0)
                dist[node] = 0;
        }

        return dist[node];
    }
}
