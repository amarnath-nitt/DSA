package main.algorithms.sortings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSort {

    /**
     * How TreeSort Works
     * Build the Binary Search Tree:
     *
     * Insert each element of the array into the BST.
     * The BST property ensures that for any node, all elements in its left subtree are smaller, and all elements in its right subtree are larger.
     * In-Order Traversal:
     *
     * Perform an in-order traversal of the BST, which visits nodes in ascending order.
     * Collect the nodes during the traversal to form the sorted array.
     * */
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2, 17, 8, 9, 1};
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        // Perform TreeSort
        int[] sortedArr = treeSort(arr);

        System.out.println("Array after sorting: " + Arrays.toString(sortedArr));
    }

    // Function to perform TreeSort
    public static int[] treeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // Build the binary search tree
        TreeNode root = null;
        for (int value : arr) {
            root = insert(root, value);
        }

        // Perform in-order traversal to get sorted elements
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);

        // Convert the list to an array
        return sortedList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Class representing a tree node
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a value into the BST
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Perform in-order traversal of the BST
    public static void inOrderTraversal(TreeNode root, List<Integer> sortedList) {
        if (root != null) {
            inOrderTraversal(root.left, sortedList);
            sortedList.add(root.value);
            inOrderTraversal(root.right, sortedList);
        }
    }
}
