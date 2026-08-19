package Babylon;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static void main() {
        PalindromePartitioning p = new PalindromePartitioning();
        System.out.println(p.partition("aab"));
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)
                        && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }
        helper(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    public void helper(String s, int start, List<String> cur, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int end = start ; end < s.length(); end++) {
            if (dp[start][end]) {
                cur.add(s.substring(start, end + 1));
                helper(s, end + 1, cur, result, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
