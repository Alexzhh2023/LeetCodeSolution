public class TrappingRainWaterO1 {
    static void main() {

        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax,height[left]);
                res += leftMax - height[left];
            } else  {
                right--;
                rightMax = Math.max(rightMax,height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }
}
