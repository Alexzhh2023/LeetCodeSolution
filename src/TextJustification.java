import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    static void main() {
        List<String> list = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        System.out.println(list);
        for (String str : list) {
            System.out.println(str + " : " + str.length());
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth){
        List<String> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int numOfLetters = 0;

        for (String word : words) {
            if (word.length() + tmp.size() + numOfLetters > maxWidth) {
                for (int i = 0; i < maxWidth - numOfLetters; i++) {
                    tmp.set(i % (tmp.size() > 1? tmp.size() - 1: 1), tmp.get(i % (tmp.size() - 1 > 0 ? tmp.size() - 1 : 1)) + " ");
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tmp.size(); i++) {
                    sb.append(tmp.get(i));
                }
                res.add(sb.toString());
                tmp.clear();
                numOfLetters = 0;
            }
            tmp.add(word);
            numOfLetters+=word.length();
        }

        StringBuilder sbLL = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
            sbLL.append(tmp.get(i));
            if (i != tmp.size() - 1) {
                sbLL.append(" ");
            }
        }
        while (sbLL.length() < maxWidth) {
            sbLL.append(" ");
        }
        res.add(sbLL.toString());
        return res;
    }
}
