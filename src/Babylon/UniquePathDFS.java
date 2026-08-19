package Babylon;

public class UniquePathDFS {
    static void main() {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
       return helper(0,0,m - 1,n - 1);
    }

    public static int helper (int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        }

        int count = 0;

        if (row < m) {
            count += helper(row + 1, col, m, n);
        }
        if (col < n) {
            count += helper(row , col + 1, m, n);
        }
        return count;
    }
}
