package PracticeLeetcode.Array;

public class Q59 {
    // Given a positive integer n, generate an n x n matrix filled with elements
    // from 1 to n2 in spiral order.
    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int value = 1;
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        int left = 0;
        while (top <= bottom && left <= right) {

            // left->right
            for (int col = left; col <= right; col++) {
                result[top][col] = value++;
            }
            top++;
            // top->bottom
            for (int row = top; row <= bottom; row++) {
                result[row][right] = value++;
            }
            right--;
            // right->left
            for (int col = right; col >= left; col--) {
                result[bottom][col] = value++;
            }
            bottom--;
            // bottom->top
            for (int row = bottom; row >= top; row--) {
                result[row][left] = value++;

            }
            left++;
        }
        return result;
    }

}
