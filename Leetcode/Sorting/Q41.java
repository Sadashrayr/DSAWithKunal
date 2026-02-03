package Leetcode.Sorting;

//  FIRST MISSING POSITIVE
/* Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.*/
public class Q41 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 0 };
        int ans = missingpositive(arr);
        System.out.println(ans);

    }

    static int missingpositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] != nums[correct] && nums[i] < nums.length) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;

            }
        }
        return nums.length + 1;
    }

    static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
