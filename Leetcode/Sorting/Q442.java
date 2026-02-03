package Leetcode.Sorting;

import java.util.List;
import java.util.ArrayList;
// Find all Dupicates of the array
/*Given an integer array nums of length n  where all the integers of nums are in the range [1, n] and each integer appears at most twice, 
return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output */

public class Q442 {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> ans = Duplicate(arr);
        System.out.println(ans);

    }

    static List<Integer> Duplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else
                i++;
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(nums[j]);
            }
        }
        return result;
    }

    static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
