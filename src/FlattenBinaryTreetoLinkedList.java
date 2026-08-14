public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left!=null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root.right;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = temp;
        }
    }
}
