import java.util.Scanner;

public class StringMultiplication {
    public static void main(String[] args) {
        String num1, num2;
        int i, result=0, length, temp = 0, count, counter = 0;
        Scanner input = new Scanner(System.in);
        num1 = input.nextLine();
        num2 = input.nextLine();
        for(i=num2.length()-1; i >= 0; i--) {
            temp = 0;
            count = counter++;
            for(int j=num1.length()-1; j >= 0; j--)
                temp = (int) (temp + ( multiplication(num1.charAt(j)-'0', num2.charAt(i)-'0') * Math.pow(10, count++ )));
            result += temp;
        }
        System.out.println(result);
    }

    public static int multiplication (int a, int b) {
        int result = 0;
        for(int i=0; i<b; i++)
            result += a;
        return result;
    }
}
