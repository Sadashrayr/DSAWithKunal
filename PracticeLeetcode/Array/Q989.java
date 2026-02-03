package PracticeLeetcode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
989. Add to Array-Form of Integer
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k
, return the array-form of the integer num + k.
 */
public class Q989 {
    public static void main(String[] args) {

    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            result.add(k % 10);
            k /= 10;
        }
        Collections.reverse(result);
        return result;
    }

}
