package NewBirdTrain.Day1;

public class MinimumSizeSubarraySum {
    static void main() {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
        System.out.println(obj.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0,res = Integer.MAX_VALUE;
        while (right < nums.length) {
                sum += nums[right++];
                while (sum >= target) {
                    res = Math.min(res, right - left );
                    sum -= nums[left++];
                }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
