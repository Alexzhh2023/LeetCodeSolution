package TaskForce141;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    static void main() {
        LongestConsecutiveSequence longest = new LongestConsecutiveSequence();
        System.out.println(longest.longestConsecutive(new int [] {100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curInt = num;
                int cur = 1;
                while (set.contains(curInt + 1)) {
                    cur++;
                    curInt ++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
