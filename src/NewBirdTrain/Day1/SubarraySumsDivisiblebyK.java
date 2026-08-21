package NewBirdTrain.Day1;

import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    static void main() {
        SubarraySumsDivisiblebyK s = new SubarraySumsDivisiblebyK();
        System.out.println(s.subarraysDivByK(new int []{4,5,0,-2,-3,1}, 5));
    }

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            rem = (rem + k) % k;
            if (map.containsKey(rem)) {
                res += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
