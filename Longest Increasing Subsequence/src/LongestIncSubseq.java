public class LongestIncSubseq {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};

        //to store maximum subsequences until i
        int[] dp = new int[arr.length];
        //to store longest increasing subsequence count
        int max = 1;

        if(arr==null || arr.length==0) {
            System.out.println("0");
        }
        else {
            for(int outer=0; outer<arr.length; outer++) {
                dp[outer] = 1;
                for(int inner=0; inner<outer; inner++) {
                    if(arr[inner] < arr[outer]) {
                        dp[outer] = Math.max(dp[outer], dp[inner]+1);
                        max = Math.max(max, dp[outer]);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
