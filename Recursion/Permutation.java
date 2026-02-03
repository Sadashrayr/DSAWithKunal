package Recursion;

public class Permutation {
    public static void main(String[] args) {
         // permutation("null", "abc");
        System.out.println(permutationcount("null", "abc"));

    }

    static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1));

        }
    }

    static int permutationcount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationcount(f + ch + s, up.substring(1));

        }
        return count;
    }

}
