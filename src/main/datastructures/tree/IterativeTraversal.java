package main.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author amarnath-nitt 24/05/23
 */
public class IterativeTraversal {
    static int sum = 0;
    static int target = 3;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> resList = new ArrayList<>();
        sumElementLessThanOrEqualToTarget(root);
        System.out.println("Output: ");
        System.out.println("Sum elements less than or equal to target: " + sum);

        /**
         * DFS Traversal
         * */
        resList = inOrderTraversal(root);
        System.out.println("In-order traversal: " + resList);
        resList.clear();
        resList = preOrderTraversal(root);
        System.out.println("Pre-order traversal: " + resList);
        resList.clear();
        resList = postOrderTraversalUsingDoubleStack(root);
        System.out.println("Post-order traversal: " + resList);
        resList.clear();

        resList = postOrderTraversalUsingSingleStack(root);
        System.out.println("Post-order traversal: " + resList);
        resList.clear();

        /**
         * BFS Traversal
         * */


    }

    private static List<Integer> postOrderTraversalUsingDoubleStack(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if(root.right != null) st1.add(root.right);
            if(root.left != null) st1.add(root.left);
        }
        while(!st2.isEmpty()){
            resList.add(st2.pop().val);
        }
        return resList;
    }
    private static List<Integer> postOrderTraversalUsingSingleStack(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            if(root != null){
                st.add(root);
                root = root.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    resList.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        resList.add(temp.val);
                    }
                }
                else root = temp;
            }
        }
        return resList;
    }

    private static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            resList.add(node.val);
            if(node.right != null) {
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return resList;
    }

    private static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while (!st.isEmpty() || temp != null){
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            else{
                if(st.isEmpty()) break;
                temp = st.pop();
                resList.add(temp.val);
                temp = temp.right;
            }
        }
        return resList;
    }

    private static void sumElementLessThanOrEqualToTarget(TreeNode root) {
        if(root == null){
            return;
        }
        sumElementLessThanOrEqualToTarget(root.left);
        if(root.val <= target){
            sum = sum + root.val;
        }
        sumElementLessThanOrEqualToTarget(root.right);
    }
}
