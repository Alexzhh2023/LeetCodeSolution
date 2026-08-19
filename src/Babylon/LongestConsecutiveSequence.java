package Babylon;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    static void main() {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int cur = 1;
                while (set.contains(current + 1)) {
                    current++;
                    cur++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
