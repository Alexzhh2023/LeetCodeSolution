package Babylon;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    static void main() {
        System.out.println(generateTrees(2));
    }
    public static List<TreeNode> generateTrees(int n){

        return helper (1,n);
    }
    public static List<TreeNode> helper (int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> leftNode = helper(start, i - 1);
            List<TreeNode> rightNode = helper(i + 1, end);
            for (TreeNode left : leftNode){
                for (TreeNode right : rightNode){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
