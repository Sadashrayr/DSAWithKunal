package PracticeLeetcode.Array;

import java.util.Arrays;

public class Q867 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] trans = transpose(matrix);
        System.out.println(Arrays.deepToString(trans));
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] trans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = matrix[i][j];

            }
        }
        return trans;
    }

}
