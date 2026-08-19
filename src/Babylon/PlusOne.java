package Babylon;

import java.util.Arrays;

public class PlusOne {
    static void main() {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }

    public static int[] plusOne(int[] digits) {
       for (int i = digits.length - 1; i >= 0; i--) {
           if (digits[i] == 9) {
               digits[i] = 0;
           } else {
               digits[i] = digits[i] + 1;
               return digits;
           }
       }

       int [] result = new int[digits.length + 1];
       result[0] = 1;
       return result;
    }
}
