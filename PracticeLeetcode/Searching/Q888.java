package PracticeLeetcode.Searching;

import java.util.Arrays;

public class Q888 {
    /*
     * Fair Candy Swap
     * Alice and Bob have a different total number of candies. You are given two
     * integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of
     * candies of the ith box of candy that Alice has and bobSizes[j] is the number
     * of candies of the jth box of candy that Bob has.
     * 
     * Since they are friends, they would like to exchange one candy box each so
     * that after the exchange, they both have the same total amount of candy. The
     * total amount of candy a person has is the sum of the number of candies in
     * each box they have.
     * 
     * Return an integer array answer where answer[0] is the number of candies in
     * the box that Alice must exchange, and answer[1] is the number of candies in
     * the box that Bob must exchange. If there are multiple answers, you may return
     * any one of them. It is guaranteed that at least one answer exists.
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(bobSizes);
        int sumAlice = sum(aliceSizes);
        int sumBob = sum(bobSizes);
        int diff = (sumAlice - sumBob) / 2;
        for (int a : aliceSizes) {
            int target = a - diff;
            if (binarysearch(bobSizes, target)) {
                return new int[] { a, target };
            }
        }
        return new int[] { -1, -1 };

    }

    public int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public boolean binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
