public class MaximumSubarray {

    static void main() {
        System.out.println(maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int total = 0, res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (total < 0) {
                total = nums[i];
            } else {
                total += nums[i];
            }

            res = Math.max(res, total);
        }
        return res;
    }


}
