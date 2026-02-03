import java.util.Scanner;

public class casecheck {
    public static void main(String[] args) {
        System.out.println("Enter the Character or alphabet");
        Scanner in = new Scanner(System.in);
        char ch = in.next().trim().charAt(0);
        if (ch >= 'a' && ch <= 'z') {
            System.out.println("It is a lower case alphabet");

        } else if (ch >= 'A' && ch <= 'Z') {
            System.out.println("It is an Upper case alphabet");
        } else {
            System.out.println("This is not an alphabet");
        }
    }

}
