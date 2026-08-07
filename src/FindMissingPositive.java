public class FindMissingPositive {
    static void main() {
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }

    public static int firstMissingPositive(int[] nums) {

        // first filter out all irrelevant number
        int n = nums.length;
        int res = n + 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Mark the presence of the value
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if (cur > 0 && cur <= n) {
                nums[cur - 1] = - Math.abs(nums[cur - 1]);
            }
        }

        // find the first positive number in current array and index + 1 will be the result

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res = i + 1;
                break;
            }
        }
        return res;
    }
}

