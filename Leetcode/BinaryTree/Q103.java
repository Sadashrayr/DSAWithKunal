package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while (!deque.isEmpty()) {
            int levelsize = deque.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {

                if (!reverse) {
                    TreeNode currentNode = deque.pollFirst();
                    currentlevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentlevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                }
            }
            reverse = !reverse;
            result.add(currentlevel);
        }
        return result;

    }

}
