public class SingleNumber_II {

    static void main() {
        SingleNumber_II s = new SingleNumber_II();
        System.out.println(s.singleNumber(new int[]{2,2,3,2}));
    }
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        int res = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> bit) & 1;
            }
            res += (count %3) << bit;
        }
        return res;
    }
}
