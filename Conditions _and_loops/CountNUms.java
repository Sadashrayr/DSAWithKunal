import java.util.Scanner;

public class CountNUms {
    public static void main(String[] args) {
        /*
         * int n = 455456;
         * int count = 0;
         * while (n > 0) {
         * int rem = n % 10;
         * if (rem == 5) {
         * count++;
         * }
         * n = n / 10; // n/=10
         * }
         * System.out.println(count);
         */
        Scanner num = new Scanner(System.in);
        System.out.println("\n Enter The number to count occurence: ");
        int a = num.nextInt();
        System.out.println("Enter The number to be counted");
        int b = num.nextInt();
        int temp = a;
        int count = 0;
        while (a > 0) {
            int rem = a % 10;
            if (rem == b) {
                count++;
            }
            a = a / 10;
        }
        System.out.println(" The occurence of number" + b + "in the number" + temp + "is :\t" + count);
    }
}
