package Leetcode.BinarySearch;

public class Q34 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 5, 7, 7, 7, 7, 8, 8, 10 };
        int[] ans = searchRange(nums, target);
        System.out.println(ans);
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        // check for first occurence of target
        int startvalue = search(nums, target, true);
        int endvalue = search(nums, target, false);
        ans[0] = startvalue;
        ans[1] = endvalue;
        return ans;
    }

    // this function return the value of index value of target
    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // potential ans found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
