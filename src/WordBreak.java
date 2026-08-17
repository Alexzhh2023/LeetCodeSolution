import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    static void main() {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa"))));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] memo = new Boolean[s.length()];
        return helper(s, 0, wordDict, memo);
    }
    boolean helper(String s, int start, List<String> wordDict, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word) && helper(s, end, wordDict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}
