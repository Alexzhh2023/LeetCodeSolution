package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {

    Deque<int []> stack;
    public void StockSpanner() {
        stack = new ArrayDeque<>();
    }

    // stack contains int [] {price, span}
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return stack.peek()[1];
    }
}
