package Babylon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    static void main() {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new ArrayList<>();
        helper(board, 0, result);
        return result;
    }

    public static void helper(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isCurrentPositionValid(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }



    public static boolean isCurrentPositionValid(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        int maxRight = Math.min (row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
