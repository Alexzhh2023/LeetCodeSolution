public class ValidateBinarySearchTree {

    static void main() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);

        System.out.println(isValidBST(root));
    }

    public static  boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public  static boolean helper(TreeNode root, long min, long max) {

        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;


        boolean leftValid = helper(left, min, root.val);
        boolean rightValid = helper(right, root.val, max);

        return leftValid && rightValid;
    }
}
