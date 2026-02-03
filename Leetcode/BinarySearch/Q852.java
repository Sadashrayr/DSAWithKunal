package Leetcode.BinarySearch;
// 162 also

/*  You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.Return the index of the peak element.Your task is to solve it in O(log(n)) time complexity.*/
public class Q852 {
    public static void main(String[] args) {
        int[] arr = { 0, 10, 5, 2 };
        System.out.println(peak(arr));
    }

    static int peak(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] > arr[m + 1]) {
                e = m;
            } else if (arr[m] < arr[m + 1]) {
                s = m + 1;
            } else {
                return m;
            }
        }

        return arr[s];
    }
}
