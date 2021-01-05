public class MST {
    public void primMST(int[][] graph, int V) {
        //to store visited vertices
        boolean[] visited = new boolean[V];
        //to store constructed MST
        int[] mst = new int[V];
        //to store weights to pick the minimum one each time
        int[] weight = new int[V];
        //initialize all weights as infinite
        for(int i=0;i<V;i++) {
            weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        //initialize root as 0 so it gets picked first
        weight[0] = 0;
        //root of first node is always -1
        mst[0] = -1;

        for(int i=0; i<V-1; i++) {
            //pick the minimum weighted vertex from the set of vertices not yet visited
            int mindex = minimumWeight(weight, visited);
            //add the picked vertex as visited
            visited[mindex] = true;
            //updating weights and mst of neighbours of the picked minimum weighted vertex
            for(int j=0; j<V;j++) {
                if(graph[mindex][j]!=0 && !visited[j] && graph[mindex][j]<weight[j]) {
                    mst[j] = mindex;
                    weight[j] = graph[mindex][j];
                }
            }
        }
        printMST(mst, graph );
    }

    public void printMST(int[] mst, int[][] graph) {
        for(int i=1; i<mst.length;i++) {
            System.out.println(mst[i] + " - " + i + "\t" + graph[i][mst[i]]);
        }
    }

    public int minimumWeight(int[] weight, boolean[] visited) {
        int min = Integer.MAX_VALUE, pos = -1;
        for(int i=0; i<weight.length; i++) {
            if (!visited[i] && weight[i] < min) {
                min = weight[i];
                pos = i;
            }
        }
        return pos;
    }
}
