package Arrays;

import java.util.Scanner;

public class Maximum {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements in array");
        Scanner n = new Scanner(System.in);
        int m = n.nextInt();
        int[] arr = new int[m];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < m; i++) {
            arr[i] = n.nextInt();
        }
        System.out.println("Enter the range of the array in which u want to check");
        int s = n.nextInt();
        int e = n.nextInt();
        System.out.println("The Maximum value in range array is " + maxRange(arr, s, e));
    }

    /*
     * private static int max(int[] arr) {
     * int maxval = arr[0];
     * for (int i = 1; i < arr.length; i++) {
     * if (arr[i] > maxval) {
     * maxval = arr[i];
     * }
     * }
     * return maxval;
     * }
     */
    private static int maxRange(int[] arr, int start, int end) {
        int maxval = arr[start];
        for (int i = 1; i < end; i++) {
            if (arr[i] > maxval) {
                maxval = arr[i];
            }
        }
        return maxval;
    }

}
