package Babylon;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderAndPostOrderTraversal {
    static void main() {

    }

    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i= 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        int postIndex = postorder.length-1;
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);

        TreeNode rightNode = helper(postorder, index + 1, end - 1);
        TreeNode leftNode = helper(postorder, start, index - 1);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
