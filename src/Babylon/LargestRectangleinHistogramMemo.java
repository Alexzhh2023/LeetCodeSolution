package Babylon;

public class LargestRectangleinHistogramMemo {
    static void main() {
        System.out.println(largestRectangleArea(new int [] {4,2,0,3,2,4,3,4}));
    }

    public static int largestRectangleArea(int[] heights) {

        int [] left = new int [heights.length];
        int [] right = new int [heights.length];
        left[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int cur = i - 1;
            while (cur >= 0 && heights[cur] >= heights[i]) {
                cur = left[cur] - 1;
            }
            left[i] = cur + 1;
        }

        right[heights.length - 1] = heights.length - 1;

        for (int i = heights.length - 2; i >= 0; i--) {
            int cur = i + 1;
            while (cur<heights.length && heights[cur] >= heights[i]) {
                cur = right[cur] + 1;
            }
            right[i] = cur - 1;
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i] * (right[i] - left[i] + 1);
            res = Math.max(res, cur);
        }
        return res;

    }
}
