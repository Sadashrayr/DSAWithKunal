package LinearSearch;

import java.util.Scanner;
import java.util.Arrays;

public class Linearsearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = in.nextInt();
        System.out.println("enter the array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the number you want to search");
        int num = in.nextInt();
        search(arr, num);
        in.close();

    }

    static void search(int[] array, int num) {
        int found = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                System.out.println("The number " + num + " is found at the " + (i + 1) + " loction or at index " + i);
            }
            found++;
        }
        if (found == 0) {
            System.out.println("The number " + num + "is not present in the array.");
        }
    }

}
