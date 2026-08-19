package Babylon;

import java.util.ArrayList;

public class PalindromeNumber {
    static void main() {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();


        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }

        int j = 0;
        int k = list.size() - 1;
        while (j < k) {
            if (list.get(j++) != list.get(k--)) {
                return false;
            }
        }
        return true;









//        String number = String.valueOf(x);
//        int i = 0;
//        int j = number.length()-1;
//
//        while (i < j) {
//            if (number.charAt(i++) != number.charAt(j--)) {
//                return false;
//            }
//        }
//        return true;
    }
}
