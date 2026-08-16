import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_II {
    static void main() {
        PalindromePartitioning_II p = new PalindromePartitioning_II();
        System.out.println(p.minCut("ab"));
    }

    public int minCut(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];

        for (int start = len - 1; start >= 0; start--) {
            for (int end = start;  end < len; end++) {
                if (s.charAt(start) == s.charAt(end)
                && (end - start <= 2 || dp[start+1][end-1])) {
                    dp[start][end] = true;
                }
            }
        }
        helper(s, 0, new ArrayList<>(), dp);
        return res;

    }
    int res = Integer.MAX_VALUE;

    public void helper(String s, int start, List<String> cur, boolean[][] dp) {
        if (start == s.length()) {
            res = Math.min(res, cur.size() - 1);
            return;
        }
        for (int end = start ; end < s.length(); end++) {
            if (dp[start][end]) {
                cur.add(s.substring(start, end + 1));
                helper(s, end + 1, cur, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
