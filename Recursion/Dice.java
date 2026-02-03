package Recursion;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(dicelist("", 4));

    }

    static void dice(String p, int target) {

        if (target == 0) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> dicelist(String p, int target) {

        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(dicelist(p + i, target - i));
        }
        return list;
    }
}
