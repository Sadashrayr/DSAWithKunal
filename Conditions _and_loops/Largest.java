import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        System.out.println("Enter Three numbers a,b,c");
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a > b && a > c) {
            System.out.println(" The largest number is a" + a);
        } else if (b > a && b > c) {
            System.out.println("The largest number is b " + b);
        } else {
            System.out.println("The largest number is c " + c);
        }
    }

}
