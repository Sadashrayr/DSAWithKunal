package Sorting;

import java.util.Arrays;

public class Countsort {
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int[] countArray = new int[max + 1];
        for (int num : arr) {
            countArray[num]++;
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 10, 9, 2, 4, 9, 7,7 };
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
