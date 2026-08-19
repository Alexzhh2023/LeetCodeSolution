package TaskForce141;

import java.util.HashMap;

public class MinimumWindowSubstring {
    static void main() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t){
        if (s.length() <  t.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int index = 0;
        int res = Integer.MAX_VALUE;
        int resStart = 0;
        int count = t.length();

        while (index < s.length()){
            char c = s.charAt(index);
            if (map.containsKey(c)){
                if (map.get(c) > 0){
                    count --;
                }
                map.put(c, map.get(c) - 1);
            }

            while (count == 0) {
                if (index - start + 1< res) {
                    res = index - start + 1;
                    resStart = start;
                }
                char d = s.charAt(start);
                if (map.containsKey(d)){
                    if (map.get(d) >= 0){
                        count ++;
                    }
                    map.put(d, map.get(d) + 1);
                }
                start++;
            }
            index++;
        }

        return res == Integer.MAX_VALUE? "" : s.substring(resStart, resStart + res);
    }
}
