package Babylon;

public class EditDistanceRecursive {
    static void main() {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        } else if (word2.isEmpty()) {
            return word1.length();
        }
        return helper(word1,word2, 0 , 0 );
    }

    private static int helper(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        if (index2 == word2.length()) {
            return word1.length() - index1;
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return helper(word1, word2, index1 + 1, index2 + 1);
        }

        int replace = 1 + helper(word1, word2, index1 + 1, index2 + 1);
        int delete = 1 + helper(word1, word2, index1 + 1, index2);
        int insert = 1 + helper(word1, word2, index1, index2 + 1);

        return Math.min(replace, Math.min(delete, insert));
    }
}
