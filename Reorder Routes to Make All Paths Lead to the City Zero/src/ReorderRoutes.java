import java.util.*;

public class ReorderRoutes {
    public static void main(String[] args) {
        int n = 6, connections[][] = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
        //for storing reordered routes
        int result = 0;
        //for storing original connections
        Set<String> org = new HashSet<>();

        //for building adjacency list
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        //allocate memory for hashset
        for(int[] conn : connections) {
            adj.putIfAbsent(conn[0], new HashSet<>());
            adj.putIfAbsent(conn[1], new HashSet<>());
        }

        //build hashset of form "src,dest" & build bidirectional adjacency list
        for(int[] conn : connections) {
            org.add(conn[0] + "," + conn[1]);
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;

        while(! q.isEmpty()) {
            int parent = q.poll();
            for(int child : adj.get(parent)) {
                if(visited[child])
                    continue;
                visited[child] = true;
                if(! org.contains(child + "," + parent))
                    result++;
                q.offer(child);
            }
        }
        System.out.println(result);
    }
}
