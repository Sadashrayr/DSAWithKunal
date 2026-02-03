import java.util.Stack;

public class Q1541 {
    public static void main(String[] args) {

    }

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertion = 0;
        int need = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need += 2;
                if (need % 2 == 1) {
                    insertion++;
                    need--;
                }
            } else {
                need--;
                if (need < 0) {
                    insertion++;
                    need = 1;
                }
            }
        }
        return insertion + need;
    }
}
