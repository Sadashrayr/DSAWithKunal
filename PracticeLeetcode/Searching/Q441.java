package PracticeLeetcode.Searching;

public class Q441 {

    // 441. Arranging Coins

    // You have n coins and you want to build a staircase with these coins. The
    // staircase consists of k rows where the ith row has exactly i coins. The last
    // row of the staircase may be incomplete.

    // Given the integer n, return the number of complete rows of the staircase you
    // will build.

    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long coins = (mid + 1) * mid / 2;
            if (coins == n) {
                return (int) mid;
            } else if (coins < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return 0;
    }

}
