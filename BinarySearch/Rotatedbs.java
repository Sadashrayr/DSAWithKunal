package BinarySearch;

public class Rotatedbs {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(arr, target));

    }

    static int search(int[] arr, int target) {
        int pivot = pivot(arr);
        int firstcheck = bsearch(arr, 0, pivot - 1, target);
        if (firstcheck != -1)
            return firstcheck;
        return bsearch(arr, pivot + 1, arr.length - 1, target);
    }

    static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // 4 cases
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int bsearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else
                return mid;
        }
        return -1;
    }
}
