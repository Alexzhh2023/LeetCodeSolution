public class removeElement {

    static void main() {
        System.out.println(removeElement(new int []{3,2,2,3},3));
    }


    public static int removeElement(int [] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
