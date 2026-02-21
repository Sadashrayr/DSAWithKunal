package Trees.BinaryTree;

public class findPath {
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

    public boolean findPath(Node node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }
        return helper(node, arr, 0);
    }

    boolean helper(Node node, int[] arr, int index) {
        if (node == null) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

}
