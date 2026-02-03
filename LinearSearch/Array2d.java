package LinearSearch;

import java.util.Scanner;
import java.util.Arrays;

public class Array2d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The dimension of 2d array ");
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("enter the array of " + m + "X " + n + " size");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("enter the number to find ");
        int num = in.nextInt();
        search(arr, num);
        in.close();
    }

    static void search(int[][] array, int num) {
        int found = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == num) {
                    System.out.println("The number " + num + " is found at location " + i + " " + j + " in the array :"
                            + Arrays.deepToString(array));
                    found++;
                }
            }
        }
        if (found == 0) {
            System.out.println("The number is not present");
        }
    }

}
