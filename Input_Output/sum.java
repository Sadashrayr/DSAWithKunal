import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num1 = input.next();
        String num2 = input.next();

        String c = num1 + num2;
        System.out.println("Sum=" + c);
    }

}
