package PracticeLeetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        while (top <= bottom && left <= right) {
            // left->right
            for (int col = left; col <= right; col++) {
                answer.add(matrix[top][col]);
            }
            top++;
            // top->bottom
            for (int row = top; row <= bottom; row++) {
                answer.add(matrix[row][right]);
            }
            right--;
            // right->left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    answer.add(matrix[bottom][col]);
                }
                bottom--;
            }
            // bottom-> top
            if (left <= right) {

                for (int row = bottom; row >= top; row--) {
                    answer.add(matrix[row][left]);
                }
                left++;
            }

        }
        return answer;

    }

}
