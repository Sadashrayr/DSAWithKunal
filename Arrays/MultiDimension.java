package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size of the array(mxn)");
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Enter the data of array");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        // System.out.println("The array is \n" + Arrays.deepToString(arr));
        // Enhanced way of for lop
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        /*
         * for (int i = 0; i < m; i++) {
         * System.out.print("[");
         * for (int j = 0; j < n; j++) {
         * System.out.print(arr[i][j]);
         * if (j < n - 1) {
         * System.out.print(", ");
         * }
         * }
         * System.out.println("]");
         * }
         * 
         * System.out.println(arr[1][1]);
         */

    }

}
