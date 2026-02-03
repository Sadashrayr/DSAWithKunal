package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Input {
    public static void main(String[] args) {
        System.out.println("ENter the Size of array of string ");
        Scanner n = new Scanner(System.in);
        int no = n.nextInt();
        /*
         * int[] arr = new int[no];
         * System.out.println("Enter the array");
         * Scanner index = new Scanner(System.in);
         * for (int i = 0; i < no; i++) {
         * arr[i] = index.nextInt();
         * }
         * System.out.println(Arrays.toString(arr));
         */
        // array of object
        String[] str = new String[no];
        System.out.println("Enter thea Array ");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < no; i++) {
            str[i] = in.next();
        }
        System.out.println(Arrays.toString(str));

    }

}
