package Babylon;

public class ConvertSortedArraytoBinarySearchTree {

    static void main() {
        ConvertSortedArraytoBinarySearchTree obj = new ConvertSortedArraytoBinarySearchTree();
        int [] nums = new int [] {-10,-3,0,5,9};
        TreeNode res = obj.sortedArrayToBST(nums);
        BinaryTreeInorderTraversal showTree = new BinaryTreeInorderTraversal();
        System.out.println(showTree.inorderTraversal(res));

    }



    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return helper(start, end, nums);
    }

    public TreeNode helper(int start, int end, int[] nums) {


        if (start > end) {
            return null;
        }

        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftNode = helper(start, mid- 1, nums);
        TreeNode rightNode = helper(mid+1, end, nums);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
