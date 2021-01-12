import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Suggestions {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        String reg = "[]?";
        int counter = 0;
        StringBuilder regex = new StringBuilder();
        List<List<String>> result = new ArrayList<>();

        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            counter = 0;
            regex.append(reg);
            regex.insert(1, searchWord.substring(0, i));
            for (String prod : products) {
                if (Pattern.matches(regex.toString(), prod)) {
                    if (counter != 3) {
                        result.get(i - 1).add(prod);
                        counter++;
                    }
                }
            }
            regex = new StringBuilder();
        }
        System.out.println(result);
    }
}
