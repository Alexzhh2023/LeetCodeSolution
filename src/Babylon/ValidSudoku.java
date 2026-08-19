package Babylon;

import java.util.HashSet;

public class ValidSudoku {
    static void main() {
        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> [] row = new HashSet[9];
        HashSet<Character> [] col = new HashSet[9];
        HashSet<Character> [] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i]  = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char v =  board[r][c];
                if (v == '.') continue;

                int boxIndex = r/3 + (c/3) * 3;
                if (row[r].contains(v) ||  col[c].contains(v) || box[boxIndex].contains(v)) {
                    return false;
                }
                row[r].add(v);
                col[c].add(v);
                box[boxIndex].add(v);
            }
        }
        return true;

    }
}
