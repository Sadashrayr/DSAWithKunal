
/*1480. Running Sum of 1d Array
Hint
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

  */
import java.util.Arrays;

public class Q1480 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int runningsum[] = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < runningsum.length; i++) {
            runningsum[i] = sum + nums[i];
            sum = sum + nums[i];
        }
        System.out.println(Arrays.toString(runningsum));
    }

}
