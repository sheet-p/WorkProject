public class UF {
    int[] parent;
    int compCount;

    UF(int N) {
        parent = new int[N];
        for(int i=0; i<N; i++) parent[i] = i;
        compCount = N;
    }

    public boolean union(int v1, int v2) {
        int pv1 = find(v1);
        int pv2 = find(v2);
        if(pv1 == pv2) return false;
        parent[pv1] = pv2;
        compCount--;
        return true;
    }

    private int find(int v) {
        while(v != parent[v]) v = parent[v];
        return v;
    }

    public int getCount() {
        return compCount;
    }
}
