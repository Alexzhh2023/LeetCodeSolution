import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    static void main() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int first = -1, last = -1;
        while (start < end) {
            int mid = start + (end - start) /2;
            if (nums[mid] == target) {
                while (mid <= end) {
                    if (mid < end && nums[mid + 1] == target) {
                        mid = mid+1;
                    } else {
                        last = mid;
                        break;
                    }
                }

                while (mid >= start)  {
                    if (mid > start && nums[mid - 1] == target) {
                        mid = mid - 1;
                    } else {
                        first = mid;
                        break;
                    }
                }

            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return new int[]{first, last};
    }
}
