package PracticeLeetcode.Searching;

public class Q1351 {
    /*
     * 1351. Count Negative Numbers in a Sorted Matrix
     * Given a m x n matrix grid which is sorted in non-increasing order both
     * row-wise and column-wise, return the number of negative numbers in grid.
     */
    public int countNegatives(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int r = 0;
        int c = n;
        int count = 0;
        while (r <= m && c >= 0) {
            if (grid[r][c] < 0) {
                count += (m - r) + 1;// +1 for itself;
                c--;
            } else {
                r++;
            }
        }
        return count;
    }
}
