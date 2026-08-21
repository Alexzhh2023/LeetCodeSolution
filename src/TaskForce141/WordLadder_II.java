package TaskForce141;

import java.util.*;

public class WordLadder_II {
    static void main() {
        WordLadder_II wl = new WordLadder_II();
        System.out.println(wl.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> parentListMap = new HashMap<>();
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
                        parentListMap.computeIfAbsent(newWord, k -> new ArrayList<>()).add(curWord);

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
            return res;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        helper(beginWord, endWord, res, path, parentListMap);
        return res;
    }

    public void helper(String beginWord, String current, List<List<String>> res, List<String> path, Map<String, List<String>> parentListMap) {
        if (beginWord.equals(current)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String curWord : parentListMap.get(current)) {
            path.addFirst(curWord);
            helper(beginWord, curWord, res, path, parentListMap);
            path.removeFirst();
        }
    }
}
