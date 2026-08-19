package Babylon;

public class RegularExpressionMatching {
    static void main() {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper (0 , 0, s, p, dp);
    }

    public static boolean helper (int i, int j, String s, String p, Boolean[][] dp) {


        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean ans = false;
        if (j == p.length()) {
            ans = i ==  s.length();
        } else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = helper(i, j + 2, s, p, dp) ||
                        firstMatch && helper(i + 1, j, s, p, dp);
            } else {
                ans = firstMatch && helper(i + 1, j + 1, s, p, dp);
            }
        }
        dp[i][j] = ans;
        return ans;
    }
}
