/* Travelling Salesman Problem (TSP): Given a set of cities and distance between every
pair of cities, the problem is to find the shortest possible route that visits every
city exactly once and returns back to the starting point.
 */
public class TravellingSalesMan {
    public static void main(String[] args) {
        // n is the number of nodes i.e. V
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        TSP t = new TSP();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        System.out.println(t.minimum(graph,visited, 0, n, 1, 0, Integer.MAX_VALUE));
    }
}
