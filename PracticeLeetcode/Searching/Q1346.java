package PracticeLeetcode.Searching;

public class Q1346 {
    /*
     * Given an array arr of integers, check if there exist two indices i and j such
     * that :
     * 
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     */
    public boolean checkIfExist(int[] arr) {
        // int i = 0;
        // int j = arr.length - 1;
        // for (; i < arr.length; i++) {
        // if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
        // return true;
        // } else {
        // j--;
        // }
        // }
        // return false;
        // binary search
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int target = arr[start] * 2;
            if (arr[end] == target) {
                start++;
                return true;
            }else if(arr[end]==target/2){
                return true;
            }
        }
    }
}
