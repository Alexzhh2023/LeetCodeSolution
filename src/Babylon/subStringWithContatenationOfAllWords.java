package Babylon;

import java.util.*;

public class subStringWithContatenationOfAllWords {

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;

        int wordSize = words[0].length();
        int wordCount = words.length;
        int sLen = s.length();

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        for (int offset = 0 ; offset < wordSize ; offset++) {
            int start = offset;
            int count = 0;
            HashMap<String, Integer> curMap = new HashMap<>();
            for (int end = offset; end <= sLen - wordSize; end+= wordSize) {
                String curWord = s.substring(end, end + wordSize);
                if (map.containsKey(curWord)) {
                    curMap.put(curWord, curMap.getOrDefault(curWord,0) + 1);
                    count++;

                    while (curMap.get(curWord) > map.get(curWord)) {
                        String startWord = s.substring(start, start + wordSize);
                        curMap.put(startWord, curMap.get(startWord) - 1);
                        count--;
                        start = start + wordSize;
                    }

                    if (count == wordCount) {
                        res.add(start);
                    }

                } else {
                    count = 0;
                    start = end + wordSize;
                    curMap.clear();
                }
            }
        }
        return res;
    }
}
