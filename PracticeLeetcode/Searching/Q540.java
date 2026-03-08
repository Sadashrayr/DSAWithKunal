package PracticeLeetcode.Searching;

public class Q540 {
    /*
     * You are given a sorted array consisting of only integers where every element
     * appears exactly twice, except for one element which appears exactly once.
     * 
     * Return the single element that appears only once.
     * 
     * Your solution must run in O(log n) time and O(1) space.
     * 
     */
    // O(log n) implies binary search
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;// to prevent integer overflow

            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }

        }
        return nums[start];
    }

}
