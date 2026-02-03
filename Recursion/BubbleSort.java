package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 7, 5, 8 };
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));

    }

    static void bubble(int[] arr, int length, int index) {
        if (length == 0) {
            return;
        }
        if (index < length) {
            if (arr[index] > arr[index + 1]) {
                // swap
                int temp = arr[index];
                arr[index] = arr[index + 1];
                arr[index + 1] = temp;
            }
            bubble(arr, length, index + 1);
        } else {
            bubble(arr, length - 1, 0);
        }

    }

}
