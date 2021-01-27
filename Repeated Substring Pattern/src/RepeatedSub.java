//LeetCode 459
public class RepeatedSub {
    public static void main(String[] args) {
        String str = "ababab";
        System.out.println(repeatedSubstringPattern(str));
    }

    private static boolean repeatedSubstringPattern(String str) {
        //corner case
        if(str==null || str.length()==0)
            return true;
        int n = str.length();
        // pattern must repeat at least twice, i.e. pattern length is at most n/2
        for(int len=1; len<=n/2; len++) {
            // s length must can be divided by the pattern length
            if((n % len != 0))
                continue;

            String pattern = str.substring(0, len);
            int i = len; // start index of 2nd pattern
            int j = i + len - 1; // end index of 2nd pattern
            while(j < n){
                String substr = str.substring(i, j + 1);
                if(!pattern.equals(substr))
                    break; // failed for this pattern, try next pattern
                i += len;
                j += len;
            }

            // if it past the last substring check, i will be n
            if(i == n)
                return true;
        }
        return false;
    }
}
