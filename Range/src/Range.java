import java.util.Scanner;
import java.util.stream.IntStream;

public class Range {
    //Write a function that accepts two integers and stores them as a range. Write another function that accepts one
    // integer, and determines if the integer is contained within a stored range.

    static IntStream stream;
    public static void main(String[] args) {
        int a=0, b=0;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        int search  = input.nextInt();
        createRange(a, b);
        
        System.out.println(isInRange(a,b,search));
    }

    private static void createRange(int a, int b) {
        stream = IntStream.range(a, b);
    }
    
    private static boolean isInRange(int a, int b, int search) {
        return search >= a && search < b;
    }
}
