package NewBirdTrain.Day1;

import TaskForce141.LongestConsecutiveSequence;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    static void main() {
        LongestSubstringWithoutRepeatingCharacters lcs = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lcs.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s){
        int start = 0, end = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        while (end < arr.length){
            if (!set.contains(arr[end])){
                set.add(arr[end]);
                res = Math.max(res, end - start + 1);
                end++;
            } else {
                while (set.contains(arr[end])) {
                    set.remove(arr[start++]);
                }
            }
        }
        return res;
    }
}
