package Babylon;

public class WildCardMatchingRecursive {
    static void main() {
        System.out.println(isMatch("aa","a"));  // time consumption is O(2^(m+n))
    }

    public static boolean isMatch(String s, String p) {
        return help(s.length() - 1, p.length() - 1 , s, p);
    }

    public static boolean help (int i, int j, String text, String pattern) {
        if (i < 0 && j < 0) return true;

        if (i < 0 && j >=0) {
            return isAllStart(j, pattern);
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
            return help(i-1, j-1, text, pattern);
        }

        if (pattern.charAt(j) == '*') {
            return help(i - 1, j, text, pattern) || help(i, j - 1, text, pattern);
        }
        return false;
    }

    public static boolean isAllStart(int k, String p) {
        for (int i = 0; i < k; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
