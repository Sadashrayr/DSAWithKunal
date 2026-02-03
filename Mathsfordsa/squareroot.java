package Mathsfordsa;

import java.util.Scanner;

public class squareroot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number you want to find sqrt");
        int n = in.nextInt();
        int p = in.nextInt();
        System.out.println("The sqrt is" + " " + Findsqrt(n, p));
    }

    static double Findsqrt(int n, int p) {
        int start = 0;
        int end = n;
        double root = 0.0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid > n) {
                end = mid - 1;
            } else if (mid * mid < n) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
