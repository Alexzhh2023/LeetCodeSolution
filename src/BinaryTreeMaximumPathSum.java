public class BinaryTreeMaximumPathSum {


    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int max = Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int val = root.val + left + right;
        max = Math.max(max, val);

        return Math.max(root.val + Math.max(left, right), 0);

    }
}
