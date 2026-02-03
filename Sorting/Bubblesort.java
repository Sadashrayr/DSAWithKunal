package Sorting.BubbleSort;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 2, 6, 7 };
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubblesort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }

            }
            if (!swapped) {// !false=true
                break;
            }
        }
    }
}
