package main.gfg.tree;

public class TreeSolution {

    static int count=0;
    public static RdaTreeNode insertNode(RdaTreeNode root, int x){
        if(root == null){
            root = new RdaTreeNode(x);
        }
        else if(root.data >= x){
            root.left = insertNode(root.left, x);
        }
        else{
            root.right = insertNode(root.right, x);
        }
        return root;
    }
    public static void main(String[] args) {
        RdaTreeNode root = null;
        root = insertNode(root, 8);
        root = insertNode(root, 7);
        root = insertNode(root, 9);
        root = insertNode(root  , 10);
        root = insertNode(root, 2);
        root = insertNode(root, 15);

//        System.out.println("Inorder traversal: ");
//        inOrderTraversal(root);
//        System.out.println("\nPreorder traversal: ");
//        preOrderTraversal(root);
//        System.out.println("\nPostorder traversal: ");
//        postOrderTraversal(root);
        int k = 1;
        System.out.println("\n"+ k + "th smallest ele: ");
        System.out.println(getKthSmallestEle(root, k).data);
        System.out.println("\nSum of first "+k + "th smallest ele: ");
        System.out.println(getSumOfFirstKthSmallestEle(root, k));
    }

    private static int getSumOfFirstKthSmallestEle(RdaTreeNode root, int k) {
        if(root == null ){
            return 0;
        }
        if(count > k){
            return 0;
        }
        int res = getSumOfFirstKthSmallestEle(root.left, k);
        if(count >= k){
            return res;
        }
        res += root.data;
        count++;
        if(count >= k){
            return res;
        }
        return res + getSumOfFirstKthSmallestEle(root.right, k);
    }

    private static RdaTreeNode getKthSmallestEle(RdaTreeNode root, int k) {
        if(root == null) return root;
        RdaTreeNode left = getKthSmallestEle(root.left, k);
        if(left != null){
            return left;
        }
        ++count;
        if(count >= k){
            return root;
        }
        return getKthSmallestEle(root.right, k);
    }

    private static void postOrderTraversal(RdaTreeNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+ " ");
    }

    private static void inOrderTraversal(RdaTreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+ " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(RdaTreeNode root) {
        if(root == null) return;
        System.out.print(root.data+ " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
