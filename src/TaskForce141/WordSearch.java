package TaskForce141;

public class WordSearch {

    static void main() {

    }

    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
        if (index == word.length()) return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ) return false;

        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        boolean found = helper(board, word, row + 1, col, visited, index + 1) ||
                helper(board, word, row - 1, col, visited, index + 1) ||
                helper(board, word, row, col + 1, visited, index + 1) ||
                helper(board, word, row, col - 1, visited, index + 1);
        visited[row][col] = false;
        return found;
    }
}
