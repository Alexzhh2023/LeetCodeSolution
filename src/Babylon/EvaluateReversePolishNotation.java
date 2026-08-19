package Babylon;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    static void main() {
        EvaluateReversePolishNotation eval = new EvaluateReversePolishNotation();
        System.out.println(eval.evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(num2 + num1);
                }  else if (token.equals("-")) {
                    stack.push(num2 - num1);
                }   else if (token.equals("*")) {
                    stack.push(num2 * num1);
                }   else if (token.equals("/")) {
                    stack.push(num2 / num1);
                }
            }  else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
