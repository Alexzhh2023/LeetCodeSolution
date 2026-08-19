package Babylon;

public class MaximumSubarrayDivideAndConquer {

    static void main() {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        return helper(nums,0, nums.length - 1);
    }

    public static int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end)/2;
        int leftMaxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            if (sum > leftMaxSum) {
                leftMaxSum = sum;
            }
        }

        int rightMaxSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            if (sum > rightMaxSum) {
                rightMaxSum = sum;
            }
        }

        int maxSum = Math.max(helper(nums, start, mid), helper(nums, mid + 1, end));
        return Math.max(maxSum, leftMaxSum + rightMaxSum);
    }

}
