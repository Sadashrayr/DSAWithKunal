package Recursion;

public class Numberexample {
    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        if (n == 5) {
            System.out.println(5);
            return;
        }
        System.out.println(n);
        // Tail recursion
        // this is the last function called
        print(n + 1);
    }

}
