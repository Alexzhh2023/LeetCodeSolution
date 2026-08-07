import java.util.Arrays;

public class ContainerWithMostWater {
    static void main() {
//        System.out.println(maxArea(new int [] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int [] {9,6,14,11,2,2,4,9,3,8}));
    }

    public static int maxArea(int[] height) {

       int max = 0;
       int i = 0, j = height.length - 1;
       while (i < j) {
           max  =  Math.max(max, (j - i) * Math.min(height[i], height[j]));
           if (height[i] < height[j]) {
               i++;
           } else {
               j--;
           }
       }

       return max;


//        if (height.length <2) return 0;
//        if (height.length == 2) {
//            return Math.min(height[0], height[1]);
//        }
//
//        int max = 0;
//        int [] leftMost = new int [height.length];
//        int [] rightMost = new int [height.length];
//        // find highest value for left side
//        int lm = height[0];
//        leftMost[0] = 0;
//        for (int i = 1; i < height.length; i++) {
//            if (height[i] > lm) {
//                leftMost[i] =i;
//                lm = height[i];
//            } else {
//                leftMost[i] = leftMost[i - 1] ;
//            }
//        }
//
//        // find highest value for right side
//        int rm = height[height.length - 1];
//        rightMost[height.length - 1] = height.length - 1;
//        for (int i = height.length - 2; i >= 0; i--) {
//            if (height[i] > rm) {
//                rightMost[i] = i;
//                rm = height[i];
//            } else  {
//                rightMost[i] = rightMost[i + 1];
//            }
//        }
//        System.out.println("leftMost:" + Arrays.toString(leftMost));
//        System.out.println("rightMost:" + Arrays.toString(rightMost));
//        int i = 0;
//        while (i < height.length) {
//            int temp = 0;
//            if (leftMost[i] == rightMost[i]) {
//                temp =  (rightMost[i+1] - leftMost[i-1]) * Math.min(height[leftMost[i-1]], height[rightMost[i+1]]);
//            } else {
//               temp =  (rightMost[i] - leftMost[i]) * Math.min(height[leftMost[i]], height[rightMost[i]]);
//            }
//            max = Math.max(max, temp);
//            System.out.println("max: " + max + "  i:" + i);
//            i++;
//        }
//        return max;
    }
}
