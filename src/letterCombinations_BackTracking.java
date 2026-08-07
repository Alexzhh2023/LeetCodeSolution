import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations_BackTracking {
    static void main() {
        System.out.println(letterCombinations("23"));
    }

    private static Map<Character, String> digitToLetters = new HashMap<>();
    private static List<String> resultList = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        processIntegerToLetter(digits, new StringBuilder(), 0);
        return resultList;
    }

    public static void processIntegerToLetter(String digits, StringBuilder sb, Integer currentIndex) {
        if (currentIndex == digits.length()) {
            resultList.add(sb.toString());
            return;
        }

        char currentDigit = digits.charAt(currentIndex);
        String letters = digitToLetters.get(currentDigit);

        if (letters.length() != 0 && letters != null) {
            for (int i = 0; i < letters.length(); i++) {
                char charcter = letters.charAt(i);
                sb.append(charcter);
                processIntegerToLetter(digits, sb, currentIndex + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
