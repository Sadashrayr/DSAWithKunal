import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number you want to check ");
        int n = in.nextInt();
        Armstrong(n);
    }

    private static void Armstrong(int n) {
        int i = n;
        int sum = 0;
        while (i > 0) {
            int a = i % 10;
            sum = sum + a * a * a;
            i = i / 10;
        }
        if (sum == n) {
            System.out.println(n + " is a Armstrong Number");
        } else {
            System.out.println(n + " Is not a Armstrong number");
        }
    }

}
