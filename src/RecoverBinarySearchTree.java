public class RecoverBinarySearchTree {

    static void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), null);
        recoverTree(root);
        System.out.println(root);
    }

    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode second = null;
    public static void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        helper(root.right);
    }
}
