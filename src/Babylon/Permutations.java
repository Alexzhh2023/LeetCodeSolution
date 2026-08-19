package Babylon;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static void main() {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums,0, new ArrayList<>());
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                helper(res, nums, i + 1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
