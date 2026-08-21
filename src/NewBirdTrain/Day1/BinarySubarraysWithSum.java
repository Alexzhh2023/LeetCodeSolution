package NewBirdTrain.Day1;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    static void main() {
        BinarySubarraysWithSum bs = new BinarySubarraysWithSum();
        System.out.println(bs.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
