package PracticeLeetcode.Array;

public class Q1832 {
    /*
     * Q1832. Check if the Sentence Is Pangram
     * 
     * A pangram is a sentence where every letter of the English alphabet appears at
     * least once.
     * 
     * Given a string sentence containing only lowercase English letters, return
     * true if sentence is a pangram, or false otherwise.
     */
    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for (char c : sentence.toCharArray()) {
            seen[c - 'a'] = true;
        }
        for (boolean b : seen) {
            if (!b)
                return false;
        }
        return true;
    }

}
