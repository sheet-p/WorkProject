//LeetCode 949 : Largest time for given digits
public class LargestTime {
    public static void main(String[] args) {
        int[] arr = {1,3,2,5};
        int i = 0, j = 0, k = 0;
        String result = "";
        for(i=0; i<4; i++) {
            for(j=0; j<4; j++) {
                for(k=0; k<4; k++) {
                    if(i==j || j==k || i==k)
                        continue;
                    String h = "" + arr[i] + arr[j];
                    String m = "" + arr[k] + arr[6-i-j-k];
                    String t = ""+h+":"+m;
                    if((h.compareTo("24"))<0 && (m.compareTo("59"))<0 && result.compareTo(t)<0 )
                        result = t;
                }
            }
        }
        System.out.println(result);
    }
}
