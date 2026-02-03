
import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        result();

    }

    static void result() {
        Scanner in = new Scanner(System.in);
        System.out.println("ENter the 1st number");
        int num1 = in.nextInt();
        System.out.println("enter other number");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum is : " + sum);
    }
}
