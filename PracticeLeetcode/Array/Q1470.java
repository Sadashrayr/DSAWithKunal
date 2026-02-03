
/*
1470. Shuffle the Array
Hint
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

*/
import java.util.Arrays;

public class Q1470 {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        int count=0;
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {

            arr[count] = nums[i];
            arr[count+1] = nums[i + n];
            count+=2;
        }
        System.out.println(Arrays.toString(arr));
    }

}
