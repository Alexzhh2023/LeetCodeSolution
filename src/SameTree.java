public class SameTree {

    static void main() {
        SameTree tree = new SameTree();

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        boolean left = helper(p.left, q.left);
        boolean right = helper(p.right, q.right);

        return left && right && (p.val == q.val);
    }
}
