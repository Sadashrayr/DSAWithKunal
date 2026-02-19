package Arrays;

import java.util.Arrays;

public class Questions {
    public static void main(String[] Args) {
        int[] arr = { 2, 0, 0, 1, 0, 3 };
        Movezeros(arr);
        System.out.println(Arrays.toString(arr));
        // System.out.println(findSecondLargest(arr));
    }

    // second Largest number
    public static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second;
    }

    // Move Zeros to End
    public static void Movezeros(int[] arr) {

        int j = arr.length - 1;
        for (int k = 0; k <= j; k++) {
            if (arr[k] == 0) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
                k--;
            }
        }

    }

}
