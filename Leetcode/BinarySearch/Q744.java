/*  You are given an lettersay of characters letters that is sorted in non-decreasing order, and a character target. 
There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.

*/

package Leetcode.BinarySearch;

public class Q744 {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'a';
        char ans = smallest(letters, target);
        System.out.println("the element is " + ans);
    }

    static char smallest(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % (letters.length)];
    }

}
