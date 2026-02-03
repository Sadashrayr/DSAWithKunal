package Mathsfordsa;

public class Primenumber {

    public static void main(String[] args) {
        /*
         * int prime = 0;
         * int notprime = 0;
         * int n = 8;
         * for (int i = 2; i < n; i++) {
         * if (n % i == 0) {
         * notprime++;
         * } else {
         * prime++;
         * }
         * }
         * if (notprime > 0) {
         * System.out.println("Notprime");
         * } else {
         * System.out.println("Prime");
         * }
         * 
         * boolean isPrime = true;
         * int n = 13;
         * if (n <= 1) {
         * isPrime = false;
         * } else {
         * for (int i = 2; i<Math.sqrt(n); i++) {
         * if (n % i == 0) {
         * isPrime = false;
         * break;
         * }
         * }
         * }
         * if (isPrime) {
         * System.out.println("Prime");
         * } else {
         * System.out.println("Not prime");
         * }
         */
        int n = 13;
        for (int i = 1; i < n; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;

        }
        return true;
    }

}
