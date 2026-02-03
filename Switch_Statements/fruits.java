
import java.util.Scanner;

public class fruits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String fruit = in.next();
        switch (fruit) {
            case "Mango":
                System.out.println("Mango");
                break;
            case "Orange":
                System.out.println("Orange");
                break;
            default:
                System.out.println("check the list");
        }

    }
}
