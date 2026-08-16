import java.util.Arrays;

public class SurroundedRegions {
    static void main() {
        SurroundedRegions sol = new SurroundedRegions();
        char[][]board = new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        sol.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < col; i++) {
            helper(board, 0, i);
            helper(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            helper(board, i, 0);
            helper(board, i, col - 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else  {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void helper(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '*';
    }
}
