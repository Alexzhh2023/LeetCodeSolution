package Babylon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIIDFS {
    static void main() {
        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
//            if (count + candidates[i] > target) {
//                break;
//            }

            list.add(candidates[i]);
            helper(candidates, target, i + 1, res, list);
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
