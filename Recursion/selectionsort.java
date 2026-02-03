package Recursion;

import java.util.Arrays;

public class selectionsort {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 2, 6, 7 };
        selection(arr, arr.length - 1, 0, 0);
        ;
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr, int length, int index, int max) {
        if (length == 0) {
            return;
        }
        if (index < length) {

            if (arr[index] > arr[max]) {
                selection(arr, length, index + 1, index);
            } else {
                selection(arr, length, index + 1, max);
            }
        } else {
            // swap
            int temp = arr[max];
            arr[max] = arr[length - 1];
            arr[length - 1] = temp;
            selection(arr, length - 1, 0, 0);
        }

    }
}
