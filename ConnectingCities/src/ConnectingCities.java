import java.util.Arrays;

public class ConnectingCities {
    public static void main(String[] args) {
        int N=3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        int res = 0;
        UF uf = new UF(N);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for(int[] conn : connections) {
            if(uf.union(conn[0]-1, conn[1]-1)) {
                res += conn[2];
            }
            if(uf.getCount() == 1) break;
        }
        System.out.println( uf.getCount() == 1 ? res : -1 );
    }
}
