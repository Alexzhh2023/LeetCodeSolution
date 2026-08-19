package Babylon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    static void main() {
        System.out.println(subsets(new int[] {1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public static void helper (int [] nums, int index, List<List<Integer>> res, List<Integer> list) {

        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
            list.add(nums[i]);
            helper(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }

    }
}
