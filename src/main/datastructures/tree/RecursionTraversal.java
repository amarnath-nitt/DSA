package main.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amarnath-nitt 24/05/23
 */
public class RecursionTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> resList = new ArrayList<>();
        int[] temp = new int[]{3, 0}; // {target, sum};
        sumElementLessThanOrEqualToTarget(root, temp);
        System.out.println("Output: ");
        System.out.println("Sum elements less than or equal to target: " + temp[1]);

        /**
         * DFS Traversal
         * */
        inOrderTraversal(root, resList);
        System.out.println("In-order traversal: " + resList);
        resList.clear();
        preOrderTraversal(root, resList);
        System.out.println("Pre-order traversal: " + resList);
        resList.clear();
        postOrderTraversal(root, resList);
        System.out.println("Post-order traversal: " + resList);
        resList.clear();

        /**
         * BFS Traversal
         * */


    }

    private static void postOrderTraversal(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        preOrderTraversal(root.left, resList);
        preOrderTraversal(root.right, resList);
        resList.add(root.val);
    }

    private static void preOrderTraversal(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        resList.add(root.val);
        preOrderTraversal(root.left, resList);
        preOrderTraversal(root.right, resList);
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, resList);
        resList.add(root.val);
        inOrderTraversal(root.right, resList);
    }

    private static void sumElementLessThanOrEqualToTarget(TreeNode root, int[] temp) {
        if (root == null) {
            return;
        }
        sumElementLessThanOrEqualToTarget(root.left, temp);
        if (root.val <= temp[0]) {
            temp[1] = temp[1] + root.val;
        }
        sumElementLessThanOrEqualToTarget(root.right, temp);
    }
}
