import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number you want to reverse");
        int num = in.nextInt();
        int rem = 0;
        int num2 = 0;
        while (num > 0) {
            rem = num % 10;
            num = num / 10;
            num2 = num2 * 10 + rem;
        }
        System.out.println(num2);
    }

}
