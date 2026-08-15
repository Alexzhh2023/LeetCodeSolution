import java.util.*;

public class WordLadder_NoDFS {
    static void main() {
        WordLadder_NoDFS wl = new WordLadder_NoDFS();
        System.out.println(wl.findLadders("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> level = new HashSet<>();
        level.add(beginWord);
        int distance = 1;
        while (!level.isEmpty()) {
            wordSet.remove(level);
            HashSet<String> nextLevel = new HashSet<>();
            for (String curWord : level) {
                char[] charArray = curWord.toCharArray();
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
                        if (newWord.equals(endWord)) {
                            return distance + 1;
                        }
                        nextLevel.add(newWord);
                    }
                    charArray[i] = origin;
                }
            }
            level = nextLevel;
            distance++;
        }
        return 0;
    }
}
