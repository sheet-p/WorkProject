import java.util.regex.Pattern;

public class WildCard {
    //LeetCode
    //Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    //
    //'?' Matches any single character.
    //'*' Matches any sequence of characters (including the empty sequence).
    //The matching should cover the entire input string (not partial).
    public static void main(String[] args) {
        String s = "", p = "******";
        StringBuilder regex = new StringBuilder();
        regex.append(p);
        if(p.contains("?")) {
            int pos = p.indexOf('?');
            regex.replace(pos, pos+1, "[\\w]{1}");
            //System.out.println(regex);

        }
        if(p.contains("*")) {
            int pos = regex.indexOf("*");
            regex.replace(pos, pos+1, "\\w*");
            System.out.println(regex);
        }
        System.out.println(Pattern.matches(regex.toString(), s));
    }
}
