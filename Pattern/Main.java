package Pattern;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        pattern28(n);
    }

    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // when one row is printed; new line
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= n; cols++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= n - rows + 1; cols++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= rows; cols++) {
                System.out.print(cols);
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int rows = 1; rows < 2 * n; rows++) {
            if (rows > n) {
                for (int cols = 1; cols < 2 * n - rows; cols++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int cols = 1; cols <= rows; cols++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }

        }
        // instead of using the if else condition statement we can easily use
        // int colsinrows=rows>n?2n-rows:rows;

    }

    static void pattern28(int n) {
        for (int rows = 1; rows < 2 * n; rows++) {
            int totalcolsinrows = rows > n ? 2 * n - rows : rows;
            int noOfSpace = n - totalcolsinrows;
            for (int s = 0; s < noOfSpace; s++) {
                System.out.print(" ");
            }
            for (int cols = 1; cols <= totalcolsinrows; cols++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
