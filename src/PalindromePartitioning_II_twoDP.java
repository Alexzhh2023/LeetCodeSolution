import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_II_twoDP {
    static void main() {
        PalindromePartitioning_II_twoDP p = new PalindromePartitioning_II_twoDP();
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
        int [] cut = new int[len];
        for (int end = 0; end < len; end++) {
            cut[end] = end;
            for (int start = 0; start <= end; start++) {
                if (dp[start][end]) {
                    if (start == 0) {
                        cut[end] = 0;
                        break;
                    } else {
                        cut[end] = Math.min(cut[end], cut[start - 1] + 1);
                    }
                }
            }
        }
        return cut[len - 1];
    }


}
