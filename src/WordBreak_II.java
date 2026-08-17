import java.util.*;

public class WordBreak_II {
    static void main() {
        WordBreak_II wb = new WordBreak_II();
        System.out.println(wb.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"))));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        return helper(s, 0, wordDict);
    }
    Map<Integer, List<String>> memo = new HashMap<>();
    private List<String> helper(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return List.of("");
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                List<String> list = helper(s, end, wordDict);
                for (String str : list) {
                    result.add(word + (str.isEmpty() ? "" : " " + str));
                }
            }
        }
        memo.put(start, result);
        return result;
    }
}
