package PracticeLeetcode.Searching;

public class Q367 {

    public boolean isPerfectSquare(int num) {
        // as we know there will be a perfect square before num/2 in num>2
        if (num == 1) {
            return true;
        }
        int end = num / 2;
        int s = 1;

        while (s <= end) {
            int mid = s + (end - s) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                s = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}
