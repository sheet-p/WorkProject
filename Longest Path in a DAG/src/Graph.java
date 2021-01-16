import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    int V;
    //adjacency list
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //toological order
    List<Integer> toporder = new ArrayList<>();

    Graph(int val) {
        this.V = val;
        //allocating memory
        for(int i=0; i<val; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void topsort() {
        //array to store indegree
        int[] inDegree = new int[V];
        //traverse adjacency list and fill the inDegrees
        for(int i=0; i<V; i++) {
            if(adj.get(i).size() != 0) {
                for(int dest : adj.get(i)) {
                    inDegree[dest]++;
                }
            }
        }
        //create a queue and enqueue all inDegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
            if(inDegree[i] == 0)
                q.add(i);
        //counter for visited nodes
        int visited = 0;
        //for storing the topological order

        while(! q.isEmpty()) {
            int u = q.poll();
            toporder.add(u);
            //decrease inDegree by 1 for all neighbours
            for(int node : adj.get(u)) {
                inDegree[node]--;
                //if inDegree becomes 0 then add to queue
                if(inDegree[node] == 0)
                    q.offer(node);
            }
            visited++;
        }
        //check for cycle
        if(visited != V) {
            System.out.println("Cycle exists");
            System.exit(0);
        }
    }
}
