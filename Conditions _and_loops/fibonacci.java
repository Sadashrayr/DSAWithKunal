import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        // Find the nth fibonacci number
        System.out.println("Enter the nth number:\t");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;// current
        int b = 1;// next integer
        int count = 2;
        while (count <= n) {
            int temp = b;
            b = b + a;
            a = temp;
            count++;

        }

        System.out.println(b);
    }

}
