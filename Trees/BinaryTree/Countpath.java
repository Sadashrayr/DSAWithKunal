package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Countpath {
    // when multiple path have same sum
    public class Node {
        int val;
        Node left;
        Node right;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    int countPaths(Node node, int sum) {
        List<Integer> path = new ArrayList<>();
        return helper(node, sum, path);
    }

    int helper(Node node, int sum, List<Integer> path) {
        if (node == null) {
            return 0;
        }
        path.add(node.val);
        int count = 0;
        int s = 0;
        // how many paths i can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();
            if (s == sum) {
                count++;
            }
        }

        count += helper(node.left, s, path) + helper(node.right, s, path);
        // backtrack
        path.remove(path.size() - 1);
        return count;
    }
}
