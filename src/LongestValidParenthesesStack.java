import java.util.LinkedList;

public class LongestValidParenthesesStack {
    static void main() {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}
