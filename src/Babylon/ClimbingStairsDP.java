package Babylon;

public class ClimbingStairsDP {
    static void main() {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int prev1 = 3;
        int prev2 = 2;
        int res = 0;

        for (int i = 3; i < n; i++) {
            res =  prev1 + prev2;
            prev1 = prev2;
            prev2 = res;

        }
        return res;
    }
}
