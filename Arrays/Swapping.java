package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Swapping {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements in array");
        Scanner n = new Scanner(System.in);
        int m = n.nextInt();
        int[] arr = new int[m];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < m; i++) {
            arr[i] = n.nextInt();

        }
        System.out.println("Enter the index of numbers  you want to swap");
        int in1 = n.nextInt();
        int in2 = n.nextInt();
        swap(arr, in1, in2);
        System.out.println(Arrays.toString(arr));

    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

}
