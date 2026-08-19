package Babylon;

public class LengthofLastWord {
    static void main() {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s){
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }
}
