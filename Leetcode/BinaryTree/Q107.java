package Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
            }
            result.add(0, currentlevel);
        }
        return result;

    }

}
