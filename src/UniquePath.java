public class UniquePath {
    static void main() {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--;
        n--;
//        if (m < n) {
//            int temp = m;
//            m = n;
//            n = temp;
//        }

        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {
            res *= i;
            res /= j;
        }
        return (int) res;
    }
}
