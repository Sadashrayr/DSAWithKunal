package BinarySearch;

import java.util.Scanner;

public class OrderAgnostic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = in.nextInt();
        System.out.println("Enter the Sorted array");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the target to search ");
        int target = in.nextInt();
        int ans = orderagnostic(arr, target);
        if (ans != -1 && ans != 0) {
            System.out.println("The target " + target + " is found at index " + ans);
        } else if (ans == 0) {
            System.out.println("The element is present in all array or array is constant");

        } else {
            System.out.println("The target is not found");
        }
    }

    static int orderagnostic(int[] arr, int target) {
        int start = 0;// start
        int end = arr.length - 1; // end
        if (arr[start] < arr[end]) {
            while (start <= end) {
                // find the middle element
                // int mid=(s+e)/2; // might be possible exceed the range of integer in java
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        } else if (arr[start] > arr[end]) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        } else {
            return 0;
        }
        return -1;

    }

}