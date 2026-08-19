package Babylon;

public class SearchInsertPosition {

    static void main() {
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res =  mid;
                break;
            }

            if (nums[mid] > target) {
                if (mid == start ) {
                    res =  nums[start] < target ? end : start;
                    break;
                } else {
                    end = mid;
                }
            } else {
                if (mid == start) {
                    res =  nums[end] < target ? end + 1 : end;
                    break;
                } else {
                    start = mid;
                }
            }
        }
        return res;
    }
}
