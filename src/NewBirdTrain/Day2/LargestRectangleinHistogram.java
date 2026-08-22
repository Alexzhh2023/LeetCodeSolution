package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleinHistogram {
    static void main() {
        LargestRectangleinHistogram obj = new LargestRectangleinHistogram();
        System.out.println(obj.largestRectangleArea(new int [] {2,1,5,6,2,3}));
    }

    public int largestRectangleArea(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                res = Math.max(res, height*width);
            }
            stack.push(i);
        }
        int n = heights.length;
        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = n - stack.peek() - 1;
            res = Math.max(res, height*width);
        }
        return res;
    }
}
