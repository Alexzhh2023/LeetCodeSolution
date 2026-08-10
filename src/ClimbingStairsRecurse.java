public class ClimbingStairsRecurse {
    static void main() {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        return helper(n, 0);
    }

    public static int helper(int n,  int count) {
        if (count == n) return  1;
        if (count > n) return 0;

        int res = 0;
        for (int i = 1; i <=2; i ++) {
            res += helper(n, count + i);
        }
        return res;
    }
}
