
/*1929. Concatenation of Array

Hint
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

  */
import java.util.Arrays;

public class Q1929 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        System.out.println(Arrays.toString(ans));
    }

}
