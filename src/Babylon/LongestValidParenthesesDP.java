package Babylon;

public class LongestValidParenthesesDP {

    static void main() {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {

        int res = 0;
        if (s == null || s.length() == 1) return 0;
        int [] endVP = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    int pre = i > 2?endVP[i-2]:0;
                    endVP[i] = pre + 2;
                } else {
                    int preIndex = i - endVP[i - 1] - 1;
                    if (preIndex >= 0 && s.charAt(preIndex) == '(') {
                        int pre = preIndex > 0? endVP[preIndex-1] : 0;
                        endVP[i] = pre + 2 + endVP[i-1];
                    }
                }
            }

            res = Math.max(res, endVP[i]);
        }

        return res;
    }
}
