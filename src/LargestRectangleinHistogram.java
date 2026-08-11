import java.util.Stack;

public class LargestRectangleinHistogram {
    static void main() {
        System.out.println(largestRectangleArea(new int [] {4,2,0,3,2,4,3,4}));
    }

    public static int largestRectangleArea(int[] heights) {

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = helper(heights, i);
            res = Math.max(res, cur);
        }
        return res;
    }

    public static int helper(int[] heights, int i) {
        int left = i, right = i;
        while (left >0 && heights[i] <= heights[left-1]) {
            left--;
        }
        while (right < heights.length - 1 && heights[i] <= heights[right+1]) {
            right++;
        }
        return (right - left + 1) * (heights[i]);
    }
}
