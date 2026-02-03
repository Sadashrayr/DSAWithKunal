/* 
1512. Number of Good Pairs
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
*/

package PracticeLeetcode.Array;

public class Q1512 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairs(nums));
    }

    static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // j=i+1 because when we are restarting the loop it will again take the index
            // from 0 hence repetition
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;

    }

    static int bestsolution(int[] nums) {
        int[] freq = new int[101];
        int count = 0;

        for (int num : nums) {
            count += freq[num];
            freq[num]++;
        }
        return count;

    }

}
