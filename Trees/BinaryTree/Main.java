package Trees.BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        // tree.prettyDisplay();
        // BinarySearchTree tree = new BinarySearchTree();
        // int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        // tree.populate(nums);
        // tree.display();
        // BinarySearchTree tree = new BinarySearchTree();
        // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // tree.populatedSorted(nums);
        // tree.display();
        System.out.println("Inorder: ");
        tree.InOrder();
        System.out.println("Pre Order: ");
        tree.preOrder();
        System.out.println("Post Order: ");
        tree.PostOrder();
    }

}
