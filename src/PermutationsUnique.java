import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsUnique {

    static void main() {
        System.out.println(permute(new int[]{1,1,1,3,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums,0, new ArrayList<>(), visited);
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if (visited[i]){
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            helper(res, nums, start+1, list, visited);
            list.remove(list.size()-1);
            visited[i] = false;

        }
    }
}
