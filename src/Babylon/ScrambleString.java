package Babylon;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    static void main() {
        System.out.println(isScramble("great", "rgeat"));
    }

    public static boolean isScramble(String s1, String s2){
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s1,s2, memo);
    }

    private static boolean helper( String s1, String s2, Map<String, Boolean> memo){

        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i = 1; i < s1.length(); i++) {
            int n = s2.length();
            boolean noSwap =
                    helper(s1.substring(0, i), s2.substring(0, i), memo) && helper(s1.substring(i), s2.substring(i), memo);
            boolean doSwap =
                    helper(s1.substring(0, i), s2.substring(n-i),memo) && helper(s1.substring(i), s2.substring(0, n - i),memo);

            if (noSwap || doSwap) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
