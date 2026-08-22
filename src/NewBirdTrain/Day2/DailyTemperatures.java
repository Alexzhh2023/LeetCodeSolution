package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    static void main() {
        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] result = new int [temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        return result;
    }
}
