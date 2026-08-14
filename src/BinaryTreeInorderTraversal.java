import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    static void main() {
        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2,new TreeNode(3),null));
        System.out.println(obj.inorderTraversal(root));
    }

    public  List<Integer> inorderTraversal(TreeNode root){
        return helper (root, new ArrayList());
    }

    private  List<Integer> helper(TreeNode root, List<Integer> list){
        if(root == null) return list;

        helper (root.left, list);
        list.add(root.val);
        helper (root.right, list);
        return list;
    }
}
