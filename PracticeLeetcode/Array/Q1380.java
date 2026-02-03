package PracticeLeetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class Q1380 {
    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int minValue = matrix[i][0];
            int colIndex = 0;
            // minimum in row
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    colIndex = j;
                }
            }
            // Column is maximum
            boolean isLucky = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][colIndex] > minValue) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                result.add(minValue);
            }
        }
        return result;
    }

}
