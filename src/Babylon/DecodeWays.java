package Babylon;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int [] memo = new int [s.length()];
        return helper(s,0, memo);
    }

    private static int helper(String s,int index, int [] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != 0) {
            return memo[index];
        }

        int count = helper(s, index + 1,  memo);
        if (index + 1 <  s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if (num <= 26) {
                count += helper(s, index + 2, memo);
            }
        }
        memo[index] = count;
        return count;
    }
}
