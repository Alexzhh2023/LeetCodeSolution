package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    static void main() {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(swm.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int [nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
