import java.util.Arrays;

public class SetMatrixZeroes {
    static void main() {
        int [][] matrix = new int[][] {{1,1,1}, {1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
