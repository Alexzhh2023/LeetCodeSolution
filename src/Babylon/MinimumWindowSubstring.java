package Babylon;

import java.util.HashMap;

public class MinimumWindowSubstring {
    static void main() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int index = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;
        int resStart = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            while (count == 0) {
                if (index - start + 1 < res) {
                    res = index - start + 1;
                    resStart = start;
                }

                char d = s.charAt(start);

                if (map.containsKey(d)) {

                    map.put(d, map.get(d) + 1);

                    // now we are missing this character again
                    if (map.get(d) > 0) {
                        count++;
                    }
                }

                start++;
            }

            index++;

        }
        return res == Integer.MAX_VALUE
                ? ""
                : s.substring(resStart, resStart + res);
    }
}
