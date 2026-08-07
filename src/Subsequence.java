import java.util.HashMap;

public class Subsequence {
    static void main() {
        System.out.println(subsequence("abcde", new String[]{""}));
//        System.out.println(subsequence("abcde", new String[]{"bb"}));
    }

    public static int subsequence(String str, String [] words) {
        // find each character frequency in str

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else  {
                charMap.put(c, 1);
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            boolean isSubsequence = false;
            HashMap<Character, Integer> targetMap = new HashMap<>(charMap);
            for (int j = 0; j < words[i].length(); j++) {
                isSubsequence = true;
                char c = words[i].charAt(j);
                if (!targetMap.containsKey(c) || targetMap.get(c) <= 0) {
                    isSubsequence = !isSubsequence;
                    break;
                } else  {
                    targetMap.put(c, targetMap.get(c) - 1);
                }
            }
            if (isSubsequence) {
                res++;
            }
        }

        return res;
    }
}
