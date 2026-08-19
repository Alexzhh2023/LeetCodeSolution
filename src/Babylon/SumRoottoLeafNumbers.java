package Babylon;

public class SumRoottoLeafNumbers {
    static void main() {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        Babylon.TreeNode node = new Babylon.TreeNode(0, null,new Babylon.TreeNode(1));
        SumRoottoLeafNumbers sum = new SumRoottoLeafNumbers();
        System.out.println(sum.sumNumbers(node));
    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    int res = 0;

    public void helper(TreeNode node, int sum){
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res += sum * 10 + node.val;
            return;
        }
        helper(node.left, sum * 10 + node.val);
        helper(node.right, sum * 10 + node.val);

    }
}
