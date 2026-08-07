import java.util.HashSet;

public class LongestSubStringWithoutRepeat {

    static void main() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int sp = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                res = Math.max(res, i - sp + 1);

            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(sp));
                    sp++;
                }

            }
            set.add(s.charAt(i));
        }
        return res;
    }
}
