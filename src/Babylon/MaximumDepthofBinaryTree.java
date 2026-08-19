package Babylon;

public class MaximumDepthofBinaryTree {

    static void main() {
        MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(test.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return helper(root);
    }

    public int helper(TreeNode root) {

        if (root == null) return 0;


        int left = helper(root.left);
        int right = helper(root.right);

        return Math.max(left, right) + 1;
    }
}
