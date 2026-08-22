package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    static void main() {
        RemoveKDigits obj = new RemoveKDigits();
        System.out.println(obj.removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && k > 0 && (arr[i] - '0') < (arr[stack.peek()] - '0')) {
                int pre = stack.pop();
                k--;
            }
            stack.push(i);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(arr[stack.pop()]);
        }
        sb.reverse();
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        if (start == sb.length()) {
            return "0";
        }
        return sb.substring(start);
    }
}
