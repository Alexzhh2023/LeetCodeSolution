package Babylon;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res = new ArrayList<>();
        helper(root, targetSum, res, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode root, int targetSum,List<List<Integer>>res, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        helper(root.left, targetSum - root.val, res, list);
        helper(root.right, targetSum - root.val, res, list);
        list.remove(list.size()-1);
    }
}
