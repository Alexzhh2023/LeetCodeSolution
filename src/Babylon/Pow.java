package Babylon;

public class Pow {
    static void main() {
        System.out.println(myPow(2.00000, 10));
    }

    public static double myPow(double x, int n){
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        int pow = 1;

        while (n != 0) {
            if ((n & 1) != 0) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }
}
