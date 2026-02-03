// SET MISMATCH
/*You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array */
package Leetcode.Sorting;

import java.util.Arrays;

public class Q645 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4 };
        int[] ans = mismatch(arr);
        System.out.println(Arrays.toString(ans));
    }

    /*
     * answer is correct but the question is asking in array
     * static List<Integer> mismatch(int[] nums) {
     * int i = 0;
     * while (i < nums.length) {
     * int correct = nums[i] - 1;
     * if (nums[i] != nums[correct]) {
     * swap(nums, i, correct);
     * } else {
     * i++;
     * }
     * }
     * List<Integer> result = new ArrayList<>();
     * for (int j = 0; j < nums.length; j++) {
     * if (nums[j] != j + 1) {
     * result.add(nums[j]);
     * result.add(j + 1);
     * }
     * }
     * return result;
     * }
     */
    static int[] mismatch(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        int result[] = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }
        return result;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
