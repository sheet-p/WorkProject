//convert from any base to any base
public class Convert {
    public static void main(String[] args) {
        String num = "100";
        int src = 10, target=36;

        int stringToInt = Integer.parseInt(num, src);
        String toTargetBase = Integer.toString(stringToInt, target);
        System.out.println(toTargetBase);
    }
}
