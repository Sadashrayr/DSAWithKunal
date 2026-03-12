package PracticeLeetcode.Sorting;

import java.util.*;

public class Q16 {
    /*
     * Given an integer array nums of length n and an integer target, find three
     * integers at distinct indices in nums such that the sum is closest to target.
     * 
     * Return the sum of the three integers.
     * 
     * You may assume that each input would have exactly one solution.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = nums[i] + nums[left] + nums[right];
            while (left < right) {
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return closest;

    }
}
