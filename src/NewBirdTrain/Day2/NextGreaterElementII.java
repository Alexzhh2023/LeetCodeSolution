package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElementII {
    static void main() {
        NextGreaterElementII solution = new NextGreaterElementII();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }

    public  int[] nextGreaterElements(int[] nums) {
        int [] result = new int [nums.length];
        Arrays.fill(result, -1);
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()] ) {
                int prev = stack.pop();
                result[prev] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
