import java.util.*;

public class SubsetsII {

    public static void main() {
        System.out.println(subsetsWithDup(new int [] {4,4,4,1,4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public static void helper (int [] nums, int index, List<List<Integer>> res, List<Integer> list) {

        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
