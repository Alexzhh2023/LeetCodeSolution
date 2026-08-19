package Babylon;

public class DecodeWaysBottomUp {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int nextOne = 1;
        int nextTwo = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur = nextOne;
                if (i + 1 < s.length()) {
                    int num = Integer.valueOf(s.substring(i, i + 2));
                    if (num <= 26) {
                        cur += nextTwo;
                    }
                }
            }
            nextTwo = nextOne;
            nextOne = cur;

        }
        return nextOne;
    }
}
