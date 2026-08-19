package Babylon;

public class WordSearch {
    static void main() {
        System.out.println(exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (helper(board, word, visited, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean helper(char[][] board,
                                  String word,
                                  boolean[][] visited,
                                  int row,
                                  int col,
                                  int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        boolean found =
                helper(board, word, visited, row + 1, col, index + 1) ||
                        helper(board, word, visited, row - 1, col, index + 1) ||
                        helper(board, word, visited, row, col + 1, index + 1) ||
                        helper(board, word, visited, row, col - 1, index + 1);

        visited[row][col] = false;

        return found;
    }
}
