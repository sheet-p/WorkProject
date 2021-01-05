public class Graph {
    int V, E;
    Edge edge[];

    class Edge{
        int src, dest;
    }

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i=0;i<E;i++)
            edge[i] = new Edge();
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

    public int isCycle(Graph graph) {
        //allocate memory for parents
        int[] parent = new int[graph.V];

        //initializing all parents
        for(int i=0; i<graph.V; i++)
            parent[i] = -1;

        for(int i=0; i<graph.E; i++) {
            int u = graph.find(parent, graph.edge[i].src);
            int v = graph.find(parent, graph.edge[i].dest);

            if(u == v)
                return 1;
            else
                graph.union(parent, u, v);
        }
        return 0;
    }
}
