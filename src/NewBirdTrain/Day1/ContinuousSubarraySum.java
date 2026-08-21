package NewBirdTrain.Day1;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    static void main() {
        ContinuousSubarraySum cs = new ContinuousSubarraySum();
        System.out.println(cs.checkSubarraySum(new int[] {23,2,4,6,7}, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (map.containsKey(rem) && i - map.get(rem) >= 2) {
                return true;
            }
            map.putIfAbsent(rem, i);
        }
        return false;
    }
}
