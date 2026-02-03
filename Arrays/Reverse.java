package Arrays;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements of array");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("The original array which u have entered is" + Arrays.toString(arr));
        reverse(arr);

        System.out.println("The reverse array is" + Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap
            swap(arr, start, end);
            start++;
            end--;
        }

    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
