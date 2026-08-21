package TaskForce141;

public class EditDistance {

    static void main() {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse", "ros"));
    }
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        } else if (word2.isEmpty()) {
            return word1.length();
        }
        return helper (word1, word2 , 0 ,0, new Integer [word1.length()][word2.length()]);
    }

    public int helper (String word1, String word2, int i, int j, Integer[][] dp) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int res = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = helper (word1, word2 , i + 1, j + 1, dp);
        } else {
            int delete = 1 + helper (word1, word2 , i + 1, j, dp);
            int replace = 1 + helper (word1, word2 , i + 1, j + 1, dp);
            int insert = 1 + helper (word1, word2 , i, j + 1, dp);
            res = Math.min(delete, Math.min(replace, insert));
        }
        return dp[i][j] = res;
    }
}
