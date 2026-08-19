package Babylon;

public class divideTwoIntegers {

    static void main() {
        System.out.println(divide(10,3));
    }

    public static int divide(int dividend, int divisor) {
        boolean needNegative = ((dividend>=0 && divisor>=0) || (dividend<0 && divisor<0)) ? false : true;
        long a =  Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long factor=0;

        while (a>=b){
            long temp = b, tempFactor = 0;
            while (temp<<1 <= a) {
                temp = temp<<1;
                tempFactor++;
            }

            factor= factor + (1L<<tempFactor);
            a = a - (b<<tempFactor);
        }

        if (factor > Integer.MAX_VALUE && needNegative) return Integer.MIN_VALUE;
        if (factor > Integer.MAX_VALUE && !needNegative) return Integer.MAX_VALUE;

        return needNegative? (int)-factor:(int)factor;
    }
}
