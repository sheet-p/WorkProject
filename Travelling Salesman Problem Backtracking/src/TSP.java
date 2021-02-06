public class TSP {
    public int minimum(int[][] graph, boolean[] visited, int currPos, int n, int count, int cost, int ans) {
        // If last node is reached and it has a link
        // to the starting node i.e the source then
        //keep the minimum value out of the total cost
        //of traversal and "ans"
        //Finally return to check for more possible values
        if(count==n && graph[currPos][0]!=0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i] && graph[currPos][i]!=0) {
                visited[i] = true;
                ans = minimum(graph, visited, i, n, count+1, cost + graph[currPos][i], ans);

                visited[i] = false;
            }
        }

        return ans;
    }
}
