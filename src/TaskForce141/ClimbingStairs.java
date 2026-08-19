package TaskForce141;

public class ClimbingStairs {

    static void main() {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(4));
    }

    public int climbStairs(int n) {
       if ( n <= 3) {
           return n;
       }

       int prev1 = 3;
       int prev2 = 2;
       int res = 0;
       for (int i = 4; i <= n; i++) {
           res = prev1 + prev2;
           prev2 = prev1;
           prev1 = res;
       }
       return res;
    }

}
