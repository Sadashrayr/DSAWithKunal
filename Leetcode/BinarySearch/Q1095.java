package Leetcode.BinarySearch;

public class Q1095 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        System.out.println(search(arr, target));
    }

    static int search(int[] arr, int target) {
        int peak = peakindex(arr);
        int firstTry = orderagnostic(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // try to search in second half
        return orderagnostic(arr, target, peak + 1, arr.length - 1);

    }

    static int peakindex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                start = mid + 1;
            else if (arr[mid] < arr[mid + 1]) {
                end = mid;
            }
        }
        return start;
    }

    static int orderagnostic(int[] arr, int target, int start, int end) {
        // end
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
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}