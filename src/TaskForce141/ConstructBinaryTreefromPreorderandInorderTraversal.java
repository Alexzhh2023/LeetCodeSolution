package TaskForce141;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    static void main() {

    }
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);
        root.left = helper(preorder, inStart, index - 1);
        root.right = helper(preorder, index + 1, inEnd);
        return root;
    }
}
