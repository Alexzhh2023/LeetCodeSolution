package Babylon;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {

        if (root == null) return 0;
        int leftDepth  =  helper(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = helper(root.right);
        if (rightDepth == -1) return -1;

        if (Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
