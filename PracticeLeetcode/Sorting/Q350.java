package PracticeLeetcode.Sorting;

import java.util.*;

public class Q350 {
    /*
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection. Each element in the result must appear as many times as it
     * shows in both arrays and you may return the result in any order.
     */

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }

        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

}
