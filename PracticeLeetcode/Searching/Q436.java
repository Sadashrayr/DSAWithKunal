package PracticeLeetcode.Searching;

import java.util.*;

public class Q436 {
    /*
     * You are given an array of intervals, where intervals[i] = [starti, endi] and
     * each starti is unique.
     * 
     * The right interval for an interval i is an interval j such that startj >=
     * endi and startj is minimized. Note that i may equal j.
     * 
     * Return an array of right interval indices for each interval i. If no right
     * interval exists for interval i, then put -1 at index i.
     * 
     * 
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int minStart = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < minStart) {
                    minStart = intervals[j][0];
                    index = j;
                }
            }
            result[i] = index;
        }
        return result;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startindex = new int[n][2];
        // store original array in and index
        for (int i = 0; i < n; i++) {
            startindex[i][0] = intervals[i][0];
            startindex[i][1] = i;
        }
        Arrays.sort(startindex, (a, b) -> a[0] - b[0]);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int left = 0;
            int right = n - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (startindex[mid][0] >= end) {
                    ans = startindex[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = ans;
        }
        return result;
    }

}
