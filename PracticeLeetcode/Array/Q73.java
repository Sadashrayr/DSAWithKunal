package PracticeLeetcode.Array;

public class Q73 {

    // 73. Set Matrix Zeroes
    // Given an m x n integer matrix matrix, if an element is 0, set its entire row
    // and column to 0's.
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstcolumn = false;
        // check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        // check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstcolumn = true;
                break;
            }
        }
        // making sure if other have zero then use first row and col as marker
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // setting zero to the entire row or column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // if any zero is in first row or first col make entire row or column zero
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;

            }
        }
        if (firstcolumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
