package LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Minimumelement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int exit = 1;
        while (exit != 0) {
            System.out.println("Enter the number of elements in the array");
            int n = in.nextInt();
            System.out.println("enter the array");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println("The minimum element of the array " + Arrays.toString(arr) + " is - " + minimum(arr));
            System.out.println("Do you want to continue or not (enter 0 for exiting and any other for continue) ");
            exit = in.nextInt();
            if (exit == 0) {
                System.out.println("Exiting. . .");
                break;
            }

        }
        in.close();
    }

    private static int minimum(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}
