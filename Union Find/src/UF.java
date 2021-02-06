public class UF {
    public static void main(String[] args) {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2----3 */
        int V=4, E=4;
        int[][] graph = {  {0, 1, 1, 0},
                           {0, 0, 1, 0},
                           {0, 0, 0, 1} ,
                           {0, 0, 0, 0} };
        Grapg g = new Graph(V, E);
        if(isCycle(g))
            System.out.println("Cycle Exists!");
        else
            System.out.println("No Cycle!");
    }
}
