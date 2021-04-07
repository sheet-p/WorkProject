//Count the number of ways to climb 'n' steps if you can take only 'x' steps
//https://www.youtube.com/watch?v=5o-kdjv7FD0&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=3&t=929s
public class Staircase {
    public static void main(String[] args) {
        int n = 4, x[] = {1,3,5};

        System.out.println(nums_ways(n,x));
    }

    private static int nums_ways(int n, int[] x) {
        if(n == 0)
            return 1;

        int total = 0;

        for(int i=0; i<x.length; i++) {
            if(n - x[i] >= 0)
                total += nums_ways(n-x[i], x);
        }

        return total;
    }
}
