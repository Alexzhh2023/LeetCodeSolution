import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static void main() {
        ConstructBinaryTreefromPreorderandInorderTraversal test
                = new ConstructBinaryTreefromPreorderandInorderTraversal();
        BinaryTreeInorderTraversal showTree = new BinaryTreeInorderTraversal();

        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        TreeNode root = test.buildTree(preorder,inorder);
        System.out.println(showTree.inorderTraversal(root));
    }
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int [] preorder,  int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);


        int index = map.get(rootVal);

        TreeNode LeftNode = helper(preorder,  inStart, index - 1);
        TreeNode rightNode = helper(preorder,  index + 1, inEnd);

        root.left = LeftNode;
        root.right = rightNode;
        return root;
    }
}
