package Backtracking;

import java.util.ArrayList;

public class allpaths {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Allpath("", board, 0, 0);
        System.out.println(" ");
        System.out.println(allpathlist("", board, 0, 0));
    }

    static void Allpath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");

            return;
        }
        if (!maze[r][c]) {
            return;
        }
        // considering this block in my path set it as false
        maze[r][c] = false;
        if (r < maze.length - 1) {
            Allpath(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            Allpath(p + "R", maze, r, c + 1);
        }
        if (r > 0) {
            Allpath(p + "U", maze, r - 1, c);
        }
        if (c > 0) {
            Allpath(p + "L", maze, r, c - 1);
        }
        // This line is where the function will be over
        // so before the function gets removed also removed the changes that were made
        // by that function
        maze[r][c] = true;
    }

    static ArrayList<String> allpathlist(String p, boolean[][] maze, int r, int c) {
        ArrayList<String> list = new ArrayList<>();
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            list.add(p);
            return list;
        }
        if (!maze[r][c]) {
            return list;
        }
        maze[r][c] = false;
        if (r < maze.length - 1) {
            list.addAll(allpathlist(p + "D", maze, r + 1, c));
        }
        if (c < maze[0].length - 1) {
            list.addAll(allpathlist(p + "R", maze, r, c + 1));
        }
        if (c > 0) {
            list.addAll(allpathlist(p + "L", maze, r, c - 1));
        }
        if (r > 0) {
            list.addAll(allpathlist(p + "U", maze, r - 1, c));
        }
        maze[r][c] = true;
        return list;
    }
}
