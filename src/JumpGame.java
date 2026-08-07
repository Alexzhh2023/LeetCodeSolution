public class JumpGame {
    static void main() {
        System.out.println(jump(new int[]{3,2,1,0,4}));
    }

    public static boolean jump(int[] nums) {
        int far = 0, near = 0;

        while (far < nums.length - 1) {
            int farest = 0;
            for (int i = near; i <= far; i++){
                farest = Math.max(farest, i + nums[i]);
            }
            near = far + 1;
            far = farest;
            if (far == 0) {
                return false;
            }

        }
        return true;
    }


}
