package Babylon;

public class SymmetricTree {
    static void main() {


    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if(left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        boolean leftValid = helper(left.left, right.right);
        boolean rightValid = helper(left.right, right.left);
        return leftValid && rightValid;
    }
}
