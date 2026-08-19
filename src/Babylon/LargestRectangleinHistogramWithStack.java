package Babylon;

import java.util.Stack;

public class LargestRectangleinHistogramWithStack {
    static void main() {
        System.out.println(largestRectangleArea(new int [] {4,2,0,3,2,4,3,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()
                    && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                res = Math.max(res, heights[index] * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {

            int index = stack.pop();

            int width;
            if (stack.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - stack.peek() - 1;
            }

            res = Math.max(res, heights[index] * width);
        }

        return res;
    }
}
