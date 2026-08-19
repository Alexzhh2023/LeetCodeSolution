package Babylon;

public class StringtoInteger {
    static void main() {
        System.out.println(0==StringtoInteger("20000000000000000000"));
        System.out.println(StringtoInteger("20000000000000000000"));
//        System.out.println(0==Babylon.StringtoInteger("words and 98"));
//        System.out.println(Babylon.StringtoInteger("words and 98"));
    }

    public static int StringtoInteger(String s) {
        if (s==null||s.length()==0) return 0;
        s = s.trim();

        int positive = 1;
        int i = 0;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            positive = -1;
            i++;
        }

        long res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
           int digit = s.charAt(i) - '0';
           res = res * 10 + digit;
            if (res * positive < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (res * positive > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
           i++;
        }

       return (int) (res * positive);
    }
}
