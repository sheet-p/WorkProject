//Given a sequence, find the length of the longest palindromic subsequence in it.
//Example :
//Input:"bbbab"
//Output:4

public class LPSubseq {
    public static void main(String[] args) {
        String str = "agbcba";
        String rev = reverse(str);
        System.out.println(longest(str, rev, str.length()-1, str.length()-1));
    }

    private static String reverse(String str) {
        if(str.length()==0 || str==null)
            return "";
        StringBuilder temp = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            temp.append(str.charAt(i));
        }
        return temp.toString();
    }

    private static int longest (String a, String b, int m, int n) {
        if(m==0 || n==0)
            return 0;
        if(a.charAt(m) == b.charAt(n))
            return 1 + longest(a, b, m-1, n-1);
        else
            return Math.max(longest(a,b,m-1,n), longest(a,b,m,n-1));
    }
}
