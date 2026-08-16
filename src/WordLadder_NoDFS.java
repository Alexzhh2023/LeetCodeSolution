import java.util.*;

public class WordLadder_NoDFS {
    static void main() {
        WordLadder_NoDFS wl = new WordLadder_NoDFS();
        System.out.println(wl.findLadders("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int length = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }

            wordSet.removeAll(beginSet);
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char origin = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origin) continue;
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        if (endSet.contains(newWord)) {
                            return length + 1;
                        }
                        if  (wordSet.contains(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    charArray[i] = origin;
                }
            }
            beginSet = nextLevel;
            length++;
        }
        return 0;
    }
}
