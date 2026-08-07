public class JumpGameIIFarAndNear {
    static void main() {
        System.out.println(jump(new int[]{3,2,1,0,4}));
    }

    public static int jump(int[] nums) {
        int far = 0;
        int near = 0;
        int jump = 0;

        while (far < nums.length-1) {
            int farest = 0;
            for (int i = near; i < far+1; i++) {
                farest = Math.max(farest, i + nums[i]);
            }
            near = far + 1;
            far = farest;
            jump++;
        }
        return jump;
    }
}
