import java.util.*;

public class WordLadder {
    static void main() {
        WordLadder wl = new WordLadder();
        System.out.println(wl.findLadders("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
    public int findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> parentList = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        boolean found = false;

        while (!level.isEmpty() && !found) {
            wordSet.removeAll(level);
            Set<String> nextLevel = new HashSet<>();
            for (String curWord : level) {
                char [] charArray = curWord.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char origin = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origin) {
                            continue;
                        }
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        nextLevel.add(newWord);
                        parentList.computeIfAbsent(newWord, k -> new ArrayList<>()).add(curWord);
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[i] = origin;
                }
            }
            level = nextLevel;
        }
        if (!found) {
            return 0;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        return helper(beginWord,endWord,parentList, path);

    }

    public int helper(String beginWord, String current, Map<String, List<String>> parentList, List<String> path) {
        if (beginWord.equals(current)) {
            return path.size();
        }
        int res = Integer.MAX_VALUE;

        for (String curWord : parentList.getOrDefault(current, new ArrayList<>())) {
            path.add(curWord);
            int cur = helper(beginWord,curWord,parentList,path);
            res = Math.min(res,cur);
            path.removeLast();
        }
        return res;
    }
}
