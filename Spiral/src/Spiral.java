public class Spiral {
    public static void main(String[] args) {
        //value to be filled
        int val = 1;
        //rows, columns
        int m = 4, n = 4;
        //row starting, column starting
        int k = 0, l = 0;
        //matrix
        int[][] mat = new int[m][n];

        while(k < m && l<n) {
            //printing first row
            for(int j=l; j<n; j++) {
                mat[k][j] = val++;
            }
            k++;

            //printing last column from remaining columns
            for(int i=k; i<m; i++) {
                mat[i][n-1] = val++;
            }
            n--;

            //prints last row from remaining rows
            if(k < m) {
                for (int j = n - 1; j >= l; j--) {
                    mat[m - 1][j] = val++;
                }
                m--;
            }

            //prints first column from remaining columns
            if(l < n) {
                for (int i = m-1; i >= k; i--) {
                    mat[i][l] = val++;
                }
                l++;
            }
        }

        //print the matrix
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println("");
        }
    }
}
