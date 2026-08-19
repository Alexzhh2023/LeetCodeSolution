package Babylon;

public class LongestPalindromicSubstring {
    static void main() {
        System.out.println(longestPalindrome("abbcccba"));
    }

    // brute force
//    public static String longestPalindrome(String s) {
//        for (int length = s.length(); length > 0; length--) {
//            for (int start = 0; start <= s.length() - length; start++) {
//                if (helper(start,start + length,s)){
//                    return s.substring(start, start + length);
//                }
//            }
//        }
//        return "";
//    }
//
//    public static boolean helper(int i, int j, String s) {
//        int left = i;
//        int right = j-1;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

        // DP
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int [] ans = new int [] {0,0};
        // initialize all base P for every character and double character (a, aa)
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

//        for (int i =0; i<n-1; i++) {
//            if (s.charAt(i) == s.charAt(i+1)) {
//                dp[i][i+1] = true;
//                ans[0] = i;
//                ans[1] = i + 1;
//            }
//        }

        for (int diff = 2 ; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j)&& dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }

            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
