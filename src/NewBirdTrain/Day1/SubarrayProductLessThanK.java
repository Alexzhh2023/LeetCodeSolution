package NewBirdTrain.Day1;

public class SubarrayProductLessThanK {
    static void main() {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int right = 0;
        int product = 1;
        int res = 0;

        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
