package PracticeLeetcode.Array;
/*
832. Flipping an Image

Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0]
 */

public class Q832 {
    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][n - 1 - j] ^ 1;
                image[i][n - 1 - j] = temp;

            }
        }
        return image;
    }
    // there is one more way in which we have to flip it once and then reversing it
    // for fliping a combination of for loop and while loop will be used and for inversing simple  if can also be used or operators ?
}
