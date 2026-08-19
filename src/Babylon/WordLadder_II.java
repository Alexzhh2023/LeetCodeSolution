package Babylon;

import java.util.*;

public class WordLadder_II {
    static void main() {
        WordLadder_II wl = new WordLadder_II();
        System.out.println(wl.findLadders("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> parentListMap = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        boolean found = false;

        while (!found && !level.isEmpty()) {
            wordSet.removeAll(level);
            Set<String> nextLevel = new HashSet<>();
            for (String curWord : level) {
                char [] charArray = curWord.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char origin = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (origin == c) {
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

        List<String> list = new ArrayList<>();
        list.add(endWord);
        helper(beginWord, endWord, parentListMap, list, res);
        return res;
    }

    public void helper(String beginWord, String current, Map<String, List<String>> parentListMap, List<String> list, List<List<String>> res) {
        if (current.equals(beginWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (String cur : parentListMap.get(current)) {
            list.add(0,cur);
            helper(beginWord, cur, parentListMap, list, res);
            list.removeFirst();
        }
    }
}
