package Babylon;

import java.util.Arrays;

public class SortColorBinary {
    static void main() {
        int [] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums,red, white);
                red++;
                white++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                swap(nums,white, blue);
                blue--;
            }
        }
    }

    public static void swap(int [] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
