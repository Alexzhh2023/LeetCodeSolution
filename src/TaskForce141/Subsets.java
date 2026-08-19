package TaskForce141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    static void main() {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int [] {1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        return helper(nums, 0, res, new ArrayList<>());
    }

    public List<List<Integer>> helper(int[] nums, int start, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
        return res;
    }
}
