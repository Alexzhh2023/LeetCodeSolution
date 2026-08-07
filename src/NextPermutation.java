import java.util.Arrays;

public class NextPermutation {
    static void main() {
        nextPermutation(new int[]{3,2,1});
    }

    public static void nextPermutation(int [] nums) {

        int breakIndex = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                breakIndex = i;
                break;
            }
        }

        if (breakIndex == -1) {
            reverse(nums,0);
        } else {
            for (int i = nums.length-1; i >= breakIndex; i--) {
                if (nums[i] > nums[breakIndex]) {
                    swap(nums, breakIndex, i);
                    reverse(nums,breakIndex+1);
                    break;
                }
            }
        }


        System.out.println(Arrays.toString(nums));
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int [] nums, int start) {
        int i = start, j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
