package PracticeLeetcode.Sorting;

import java.util.*;

public class Q455 {
    /*
     * Assume you are an awesome parent and want to give your children some cookies.
     * But, you should give each child at most one cookie.
     * 
     * Each child i has a greed factor g[i], which is the minimum size of a cookie
     * that the child will be content with; and each cookie j has a size s[j]. If
     * s[j] >= g[i], we can assign the cookie j to the child i, and the child i will
     * be content. Your goal is to maximize the number of your content children and
     * output the maximum number.
     */
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // children
        int j = 0; // cookies

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                i++;
            }

            j++;
        }

        return i;
    }
}