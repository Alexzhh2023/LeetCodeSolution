package Babylon;

import java.util.ArrayList;
import java.util.List;

public class generateParenthese {

    static void main() {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, n, "");
        return res;
    }

    public static void recurse (List<String> res, int left, int right, int n, String s) {
        if (left == right && left + right == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res,left+1, right,n,s+"(");
        }

        if (right < n) {
            recurse(res, left , right +1, n , s + ")");
        }

    }
}
