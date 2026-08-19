package Babylon;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    static void main() {
        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(obj.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(root, result);
    }

    public List<Integer> helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }


        if (root.left != null) {
            helper(root.left, result);
        }
        if (root.right != null) {
            helper(root.right, result);
        }
        result.add(root.val);
        return result;
    }
}
