package TaskForce141;

public class DecodeWays {
    static void main() {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("226"));
    }

    public int numDecodings(String s) {
        int [] memo = new int [s.length()];
        return helper (s, 0, memo);
    }

    public int helper (String s, int index, int [] memo) {
        if (index == s.length()) return 1;
        if (index > s.length()) return 0;
        if (s.charAt(index) == '0') return 0;
        if (memo[index] != 0) {
            return memo[index];
        }
        int res = 0;
        res += helper (s, index + 1, memo);
        if (index + 2 <= s.length()) {
            int cur = Integer.parseInt(s.substring(index, index + 2));
            if (cur >= 1 && cur <= 26) {
                res += helper (s, index + 2, memo);
            }
        }
        memo[index] = res;
        return res;
    }
}
