package Babylon;

public class WildCardMatchingDP {
    static void main() {
        System.out.println(isMatch("aa","a"));
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean [] pre = new boolean[m+1];
        boolean [] cur = new boolean[m+1];

        for (int i = 1; i <=m; i++) {
            pre[i] = pre[i-1] && p.charAt(i-1) == '*';
        }

        pre[0] = true;

        for (int i = 1; i <= n; i++) {
            cur[0] = false;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    cur[j] = pre[j-1];
                } else if (p.charAt(j-1) == '*') {
                    cur[j] = pre[j] || cur[j-1];
                } else {
                    cur[j] = false;
                }
            }
            boolean [] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[m];
    }
}
