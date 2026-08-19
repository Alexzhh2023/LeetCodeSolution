package TaskForce141;

import java.util.Arrays;

public class SortColors {
    static void main() {
        SortColors sc = new SortColors();
        int [] colors = new int [] {2,0,1};
        sc.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red, white);
                red++;
                white++;
            } else if (nums[white] == 2) {
                swap(nums, white, blue);
                blue --;
            } else {
                white ++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
