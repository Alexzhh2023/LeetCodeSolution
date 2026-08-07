public class JumpGameIIDFS {
    static void main() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {

        return helper(nums, 0, 0);

    }

    public static int helper(int[] nums, int start, int count) {
        if (start == nums.length -1) {
            return count;
        }
        int res = Integer.MAX_VALUE;
        for (int i = nums[start]; i > 0; i--) {
            if (start + i <  nums.length) {
                int current = helper(nums, start + i, count + 1);
                res = Math.min(res, current);
            }
        }
        return res;
    }


}
