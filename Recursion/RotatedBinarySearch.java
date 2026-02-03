package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 };
        int ans = rotatedbs(arr, 1, 0, arr.length-1);
        System.out.println(ans);

    }

    static int rotatedbs(int[] arr, int target, int s, int e) {

        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return rotatedbs(arr, target, s, m - 1);
            } else {
                return rotatedbs(arr, target, m + 1, e);
            }
        }
        if (target >= arr[m] && target <= arr[e]) {
            return rotatedbs(arr, target, m + 1, e);
        }
        return rotatedbs(arr, target, s, m - 1);
    }
}
