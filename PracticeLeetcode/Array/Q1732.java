package PracticeLeetcode.Array;

import java.util.Arrays;

public class Q1732 {
    public static void main(String[] args) {
        int[] gain = { 44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64,
                -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81 };
        int ans = largestAltitude(gain);
        System.out.println(ans);

    }

    static int largestAltitude1(int[] gain) {
        int[] height = new int[gain.length + 1];
        int sum = 0;
        height[0] = 0;
        for (int i = 1; i < height.length; i++) {

            sum += gain[i - 1];
            height[i] = sum;
        }
        Arrays.sort(height);
        return height[height.length - 1];
    }

    // without creating a new array
    static int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int g : gain) {
            curr += g;
            max = Math.max(max, curr);
        }
        return max;

    }
}
