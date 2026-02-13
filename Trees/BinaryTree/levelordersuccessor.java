package Trees.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class levelordersuccessor {
    // Explanation if a tree is traversed through BFS then the next element after
    // adding children of the node is the answer
    // for example [3,4,8,12,14,7,11,36,9,2] is BFS of a tree then the level order
    // successor of 14 is 7
    // why we are adding children because if the tree would be [3,4,8,12,14,36,9]
    // means there is no child of 8
    // then it will return the left child of the root itself i.e. 36
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

    public TreeNode findsuccesor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}
