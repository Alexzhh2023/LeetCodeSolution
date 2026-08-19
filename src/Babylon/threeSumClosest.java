package Babylon;

import java.util.Arrays;

public class threeSumClosest {

    static void main() {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target){
                    return target;
                } else  if (sum < target){
                    j++;
                } else {
                    k--;
                }

            }
        }
        return res;
    }
}
