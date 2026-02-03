package LargeNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BD();
    }

    static void BD() {
        double x = 0.03;
        double y = 0.04;
        // double ans = y - x;

        // System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans = Y.subtract(X);
        System.out.println(ans);
        // similarly we can perform some functions in it

    }

    static void BI() {
        int a = 30;
        int b = 67;
        // BigInteger A = BigInteger.valueOf(33);
        // BigInteger B = new BigInteger("3338393398983");
        BigInteger A = BigInteger.valueOf(5);
        BigInteger B = new BigInteger("6");
        BigInteger C = new BigInteger("3338393398983");
        BigInteger X = new BigInteger("333839339387390202983");
        // constants
        BigInteger D = BigInteger.TEN;
        // Addition
        BigInteger s = A.add(B);
        // System.out.println(s);
        // multiply
        BigInteger m = C.multiply(X);
        BigInteger sub = C.subtract(X);
        BigInteger d = X.divide(C);
        BigInteger rem = X.remainder(C);
        // if (C.compareTo(X) < 0) {
        // System.out.println("Yes");
        // }
        // System.out.println(rem);
        System.out.println(Factorial.fact(23));
    }

}
