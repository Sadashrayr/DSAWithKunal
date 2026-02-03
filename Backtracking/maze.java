package Backtracking;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        // System.out.println(count(3, 3));
        // path("", 3, 3);
        // System.out.println(pathlist("", 3, 3));
        // pathdiagonal("", 3, 3);
        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true }
        };
        pathrestriction("", board, 0, 0);

    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;

    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.print(p + " ");
            return;
        }
        if (r > 1) {
            path(p + "D", r - 1, c);
        }
        if (c > 1) {
            path(p + "R", r, c - 1);
        }

    }

    static ArrayList<String> pathlist(String p, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }
        if (r > 1) {
            list.addAll(pathlist(p + "D", r - 1, c));
        }
        if (c > 1) {
            list.addAll(pathlist(p + "R", r, c - 1));
        }
        return list;
    }

    static ArrayList<String> pathlistdiag(String p, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }
        if (r > 1 && c > 1) {
            list.addAll(pathlist(p + "D", r - 1, c - 1));
        }
        if (r > 1) {
            list.addAll(pathlist(p + "V", r - 1, c));
        }
        if (c > 1) {
            list.addAll(pathlist(p + "H", r, c - 1));
        }
        return list;
    }

    static void pathdiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.print(p + " ");
            return;
        }
        if (r > 1 && c > 1) {
            pathdiagonal(p + "D", r - 1, c - 1);
        }
        if (r > 1) {
            pathdiagonal(p + "V", r - 1, c);
        }
        if (c > 1) {
            pathdiagonal(p + "H", r, c - 1);
        }

    }

    // we are passing boolean maze so that where 0 will be there that part will be
    // considered as blocked or not allowed.
    static void pathrestriction(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            pathrestriction(p + "V", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathrestriction(p + "H", maze, r, c + 1);
        }

    }
}
