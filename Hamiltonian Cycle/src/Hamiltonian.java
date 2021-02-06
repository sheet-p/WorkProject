import java.util.Arrays;
import java.util.Stack;

public class Hamiltonian {
    public boolean exists(int[][] graph) {
        int V = graph.length;
        //keep track of visited vertices
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        Arrays.fill(visited, false);

        stack.push(0);
        int node = -1;
        while(! stack.isEmpty()) {
            node = stack.pop();
            while(! visited[node]) {
                visited[node] = true;

                //find all neighbours and push to stack
                for(int i=0; i<V; i++) {
                    if(graph[node][i] != 0)
                        stack.push(graph[node][i]);
                }
            }
        }
        if(graph[node][0] != 0)
            return true;
        return false;
    }
}
