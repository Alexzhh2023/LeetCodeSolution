package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    static void main() {
        TrappingRainWater r = new TrappingRainWater();
        System.out.println(r.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int waterHeight =
                        Math.min(height[i], height[stack.peek()])
                                - height[bottom];
                res += width * waterHeight;
            }
            stack.push(i);
        }
        return res;
    }
}
