import java.util.Arrays;

/*Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
        Example:
        “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 */
public class PalPartMemo {
    static int[][] memo = new int[1001][1001];
    public static void main(String[] args) {
        String str = "abbac";
        if(str==null || str.length()<2)
            System.out.println("0");
        else {
            //initialize memo
            for(int[] m : memo)
                Arrays.fill(m, -1);
            System.out.println(mcmRecur(str, 0, str.length() - 1));
        }
    }

    private static int mcmRecur(String str, int left, int right) {
        if(left >= right)
            return 0;
        if(isPalindrome(str.substring(left, right+1)))
            return 0;
        if(memo[left][right] != -1)
            return memo[left][right];
        int ans = Integer.MAX_VALUE;
        for(int k=left; k<=right-1; k++) {
            int temp = 1 + mcmRecur(str, left, k) + mcmRecur(str, k+1, right);
            ans = Math.min(ans, temp);
        }

        return memo[left][right] = ans;
    }

    private static boolean isPalindrome(String str) {
        for(int i=0, j=str.length()-1; i<str.length()/2; i++,j--) {
            if(str.charAt(i) != str.charAt(j))
                return false;
        }

        return true;
    }
}
