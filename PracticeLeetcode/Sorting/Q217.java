package PracticeLeetcode.Sorting;

import java.util.HashMap;

public class Q217 {
    /*
     * Given an integer array nums, return true if any value appears at least twice
     * in the array, and return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>(); 
       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
        if(map.get(num)>1){
            return true;
        }
       }
       return false;
    }
    

}
