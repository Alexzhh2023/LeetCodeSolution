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
            return res;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        helper(beginWord,endWord,parentList, path, res);
        return res;
    }

    public void helper(String beginWord, String current, Map<String, List<String>> parentList, List<String> path, List<List<String>> res) {
        if (beginWord.equals(current)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            res.add(newPath);
            return;
        }

        for (String curWord : parentList.getOrDefault(current, new ArrayList<>())) {
            path.add(curWord);
            helper(beginWord,curWord,parentList,path,res);
            path.removeLast();
        }
    }
}
