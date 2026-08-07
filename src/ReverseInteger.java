public class ReverseInteger {
    static void main() {
        System.out.println(reverse(1056389759));
        System.out.println(0 == reverse(1534236469));
    }

    public static int reverse(int x) {
        long res = 0;
        while (x != 0){
            int digit = x%10;
            res = res*10 + digit;
            x = x/10;

        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
}
