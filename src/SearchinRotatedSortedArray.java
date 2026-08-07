public class SearchinRotatedSortedArray {
    static void main() {
        System.out.println(search(new int[]{4,5,6,7,8,1,2}, 2));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length -1 ;

        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid-1;
                } else  {
                    start = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid+1;
                } else   {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
