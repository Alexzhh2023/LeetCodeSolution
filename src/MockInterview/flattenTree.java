package MockInterview;

public class flattenTree {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
