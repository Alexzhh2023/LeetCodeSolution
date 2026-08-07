import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    static void main() {
        System.out.println(solveNQueens(7));
    }

    public static int solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return helper (board, 0);
    }

    private static int helper(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < board[row].length; i++) {
            if (isCurrentPositionValid(board, row, i)) {
                board[row][i] = 'Q';
                count += helper(board, row + 1);
                board[row][i] = '.';
            }
        }
        return count;
    }


    private static boolean isCurrentPositionValid(char[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int leftMax = Math.min(row, col);
        for (int i = 1; i <= leftMax; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        int rightMax = Math.min(row, board.length -1 - col);
        for (int i = 1; i <= rightMax; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
