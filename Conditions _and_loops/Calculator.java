import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float result = 0;
        System.out.println(" Enter  numbers and operator to do calculations(give x or X to exit)\n");
        // Take input from user till x or X is pressed
        while (true) {
            // operator
            float num1 = in.nextFloat();
            float num2 = in.nextFloat();
            char op = in.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                // input two numbers
                if (op == '+') {
                    result = num1 + num2;
                } else if (op == '-') {
                    result = num1 - num2;
                } else if (op == '*') {
                    result = num1 * num2;
                } else if (op == '/') {
                    result = num1 / num2;
                } else if (op == '%') {
                    result = num1 % num2;
                }
            } else if (op == 'x' || op == 'X') {
                System.out.println(" Exiting");
                break;
            } else {
                System.out.println(" Check the operator and enter correct operator");
                result = 0;
            }
            System.out.println(" The result is " + result);
        }
    }
}
