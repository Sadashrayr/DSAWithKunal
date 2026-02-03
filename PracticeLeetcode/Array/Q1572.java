package PracticeLeetcode.Array;

/*
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal 
and all the elements on the secondary diagonal that are not part of the primary diagonal. */
public class Q1572 {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(mat.length);
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {

        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }

}
