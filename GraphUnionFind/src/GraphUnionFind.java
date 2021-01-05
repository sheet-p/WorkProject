public class GraphUnionFind {
    public static void main(String[] args) {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2----3 */
        int V=4, E=4;
        Graph g = new Graph(V,E);
        // add edge 0-1
        g.edge[0].src = 0;
        g.edge[0].dest = 1;

        // add edge 1-2
        g.edge[1].src = 1;
        g.edge[1].dest = 2;

        // add edge 2-3
        g.edge[2].src = 2;
        g.edge[2].dest = 3;

        // add edge 0-2
        g.edge[1].src = 0;
        g.edge[1].dest = 2;

        if (g.isCycle(g)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
