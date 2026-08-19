package Babylon;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {


    static void main() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        BinaryTreeLevelOrderTraversalII obj = new BinaryTreeLevelOrderTraversalII();
        System.out.println(obj.levelOrderBottom(root));
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while  (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list);
        }

        return result.reversed();
    }
}
