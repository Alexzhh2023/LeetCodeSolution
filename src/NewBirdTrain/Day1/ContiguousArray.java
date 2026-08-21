package NewBirdTrain.Day1;

import java.util.HashMap;

public class ContiguousArray {
    static void main() {
        ContiguousArray ca = new ContiguousArray();
        System.out.println(ca.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {

            sum+= nums[i] == 0? -1: 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
            if (map.containsKey(sum)) {
                continue;
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
