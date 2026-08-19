package TaskForce141;


public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        boolean leftValid = helper(left, min, root.val);
        boolean rightValid = helper(right, root.val, max);
        return leftValid && rightValid;
    }
}
