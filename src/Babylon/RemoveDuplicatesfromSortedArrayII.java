package Babylon;

public class RemoveDuplicatesfromSortedArrayII {
    static void main() {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(start < 2 || nums[i] != nums[start - 2]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}
