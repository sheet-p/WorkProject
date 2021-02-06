/*Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an
edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then
prints the path.
 */
public class HClass {
    public static void main(String[] args) {
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph[][] = {{0, 1, 0, 1, 0},
                          {1, 0, 1, 1, 1},
                          {0, 1, 0, 0, 1},
                          {1, 1, 0, 0, 1},
                          {0, 1, 1, 1, 0} };

        Hamiltonian h = new Hamiltonian();
        System.out.println(h.exists(graph));
    }
}
