package Babylon;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDFS {
    static void main() {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        helper (candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    public static void helper(int[] candidates, int target, int index, List<List<Integer>>res, List<Integer> list) {
        int count = getSumFromList(list);
        if (count == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (count > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target, i, res, list);
            list.remove(list.size() - 1);
        }

    }

    public static int getSumFromList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
