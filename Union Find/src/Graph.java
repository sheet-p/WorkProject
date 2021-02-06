import java.util.Arrays;

public class Graph {
    int vertices, edges;
    Graph(int v, int e) {
        vertices = v;
        edges = e;
    }

    public int find(int[] parent, int vertex) {
        if(parent[vertex] == -1)
            return vertex;
        return find(parent, parent[vertex]);
    }

    public void union(int[] parent, int u, int v) {
        int x = find(parent, u);
        int y = find(parent, v);

        parent[x] = y;
    }

    public boolean isCycle(int[][] graph) {
        //parent array
        int[] parent = new int[vertices];

        Arrays.fill(parent, -1);

        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                if(graph[i][j] != 0) {
                    int u = find(parent, i);
                    int v = find(parent, j);

                    if(u == v)
                        return true;
                    else
                        union(parent, u, v);
                }
            }
        }
        return false;
    }
}
