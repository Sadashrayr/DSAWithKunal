package PracticeLeetcode.Array;

public class Q885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        int[][] directions = {
                { 0, 1 }, // right
                { 1, 0 }, // down
                { 0, -1 }, // left
                { -1, 0 },// up
        };
        int steps = 1;
        int dir = 0;
        result[count++] = new int[] { rStart, cStart };
        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    rStart += directions[dir][0];
                    cStart += directions[dir][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {

                        result[count++] = new int[] { rStart, cStart };
                    }

                }
                dir = (dir + 1) % 4;

            }
            steps++;
        }
        return result;
    }

}
