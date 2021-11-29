import java.util.HashMap;
import java.util.Map;

public class Subdomain {
    public static void main(String[] args) {
        String[] test = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(test);

    }

    private static void subdomainVisits(String[] cpdomains) {
        //for calculating
        Map<String, Integer> calc = new HashMap<>();

        for(String test : cpdomains) {
            String[] count = test.split(" ");
            int visits = Integer.parseInt(count[0]);
            String domain = count[1];
            String[] splits = domain.split("[.]");

            int len = splits.length;
            StringBuilder temp = new StringBuilder();
            for (int i = len - 1; i >= 0; i--) {
                temp.insert(0, splits[i]);
                calc.put(temp.toString(), calc.getOrDefault(temp.toString(), 0) + visits);
                temp.insert(0, ".");
            }
        }
    }
}
