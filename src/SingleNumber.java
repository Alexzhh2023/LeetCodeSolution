import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
