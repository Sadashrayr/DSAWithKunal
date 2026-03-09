package PracticeLeetcode.Sorting;

import java.util.HashMap;

public class Q169 {
    /*
     * Given an array nums of size n, return the majority element.
     * 
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You
     * may assume that the majority element always exists in the array.
     * 
     */
    class Solution {
        public int majorityElement(int[] nums) {

            int candidate = 0;
            int count = 0;

            for (int num : nums) {

                if (count == 0) {
                    candidate = num;
                }

                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int n =nums.length;
       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
        if(map.get(num)>n/2){
            return num;
        }
       }
    return -1;
    }

}
