package Babylon;

public class ScrambleStringWithDP {
    static void main() {
        System.out.println(isScramble("great", "rgeat"));
    }

    static Boolean[][][] memo;
    public static boolean isScramble(String s1, String s2){
        int n = s1.length();
        memo = new Boolean [n][n][ n + 1];
        return helper(s1,s2, 0,0,n);
    }

    private static boolean helper( String s1, String s2, int i, int j, int len){

        if (memo[i][j][len] != null) return memo[i][j][len];
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return memo[i][j][len] = true;
        }
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }
        for (int c : count) {
            if (c !=0)  {
                memo[i][j][len] = false;
                return memo[i][j][len];
            }
        }

        for (int k = 1; k < len; k++) {
            boolean noSwap =
                    helper(s1, s2, i, j, k) && helper(s1,s2,i + k, j + k, len - k);
            boolean doSwap =
                    helper(s1,s2, i, j + len - k, k) && helper(s1, s2, i + k, j, len - k);

            if (noSwap || doSwap) {
                memo[i][j][len] = true;
                return true;
            }
        }
        memo[i][j][len] = false;
        return false;
    }
}
