package Leetcode.Sorting;

/*268 : Missing Number
Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.
*/
// AMAZON 
public class Q268 {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 3, 4, 5 };
        int ans = sort(arr);
        if (ans != -1) {
            System.out.println("The missing index : " + ans);
        } else {
            System.out.println("All are arranged");
        }

    }

    static int sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] < arr[correct]) {
                swap(arr, i, correct);
            } else
                i++;
        }
        // search for first missing element
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
