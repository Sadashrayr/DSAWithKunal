package PracticeLeetcode.Array;

public class Q53 {
    /*
     * 53. Maximum Subarray
     * Given an integer array nums, find the subarray with the largest sum, and
     * return its sum.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    public static void main(String[] args) {
        int[] num = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = maxSubArray(num);
        System.out.println(result);

    }

    public static int maxSubArray(int[] nums) {
        int currentsum = nums[0];
        int maxsum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currentsum = Math.max(currentsum + nums[i], nums[i]);
            maxsum = Math.max(maxsum, currentsum);

        }
        return maxsum;
    }
}
