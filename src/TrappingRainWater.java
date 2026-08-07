public class TrappingRainWater {
    static void main() {

        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int res = 0;
        if  (height.length <=2) return res;
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        int leftHeight = height[0];
        int rightHeight = height[height.length - 1];
        // find left heightest number at each point
        for (int i = 1; i < height.length; i ++) {
            leftHeight = Math.max(height[i-1], leftHeight);
            left[i] = leftHeight;
        }

        //find right heightest number at each point
        for (int i = height.length - 2; i > 0; i --) {
            rightHeight = Math.max(height[i + 1], rightHeight);
            right[i] = rightHeight;
        }

        // add all the available drop
        for (int i = 1; i < height.length -1; i ++) {
            int curH = Math.min(left[i], right[i]);
           if (curH > height[i]) {
               res += curH - height[i];
           }
        }

        return res;
    }
}
