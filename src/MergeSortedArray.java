import java.util.Arrays;

public class MergeSortedArray {


    static void main() {
//        int [] nums1 = new int [] {1,2,3,0,0,0};
//        int [] nums2 = new int [] {2,5,6};
//        merge(nums1,3,nums2,3);
        int [] nums1 = new int [] {0};
        int [] nums2 = new int [] {1};
        merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
