package Babylon;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    static void main() {
        System.out.println(restoreIpAddresses("101023"));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        helper(s, result,0, new ArrayList<>());
        return result;
    }

    public static void helper(String s, List<String> result, int index, List<String> list) {
        if (index == s.length() ) {
            if (list.size() == 4) {
                result.add(String.join(".", list));
            }
            return;
        }

        if (list.size() == 4) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            if (index < s.length() && s.charAt(index) == '0') {
                list.add(s.substring(index, index + 1));
                helper(s, result, index + 1, list);
                list.remove(list.size() - 1);
                break;
            }
            int  num = Integer.parseInt(s.substring(index,  index + i));
            if (num > 255) {
                return;
            } else {
                list.add(s.substring(index, index + i));
                helper(s, result, index + i, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
