package PracticeLeetcode.Sorting;

import java.util.HashSet;
import java.util.Arrays;

public class Q349 {
    /*
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection. Each element in the result must be unique and you may return
     * the result in any order.
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i] = num;
            i++;
        }
        return ans;
    }

}
