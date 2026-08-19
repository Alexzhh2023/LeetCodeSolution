package Babylon;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static void main() {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k <1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(n,k,1,res, new ArrayList<>());
        return res;
    }

    public static void helper(int n, int k, int start, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <=n;i++) {
            if (!curr.contains(i)) {
                curr.add(i);
                helper(n,k,i+1,res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
