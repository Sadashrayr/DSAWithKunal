package PracticeLeetcode.Array;

import java.util.Arrays;

public class Q566 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int r = 1;
        int c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(matrix, r, c)));

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] reshaped = new int[r][c];
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshaped[index / c][index % c] = mat[i][j];
                index++;

            }

        }
        return reshaped;
    }

}
