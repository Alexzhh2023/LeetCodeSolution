package TaskForce141;

public class BinaryTreeMaximumPathSum {

    static void main() {
        TreeNode node1 = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        BinaryTreeMaximumPathSum btp = new BinaryTreeMaximumPathSum();
        System.out.println(btp.maxPathSum(node1));
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        int val = root.val + left + right;
        max = Math.max(max, val);
        return root.val + Math.max(left, right);
    }
}
