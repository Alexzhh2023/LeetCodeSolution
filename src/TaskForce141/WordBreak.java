package TaskForce141;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    static void main() {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] dp = new Boolean[s.length()];
        return helper(s, wordDict, dp, 0);
    }

    public  boolean helper(String s, List<String> wordDict, Boolean [] dp, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }

        for (int end = index + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(index, end)) && helper(s,wordDict,dp, end)) {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}
