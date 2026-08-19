package Babylon;

import java.util.Arrays;

public class SpiralMatrixII {
    static void main() {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        int index = 1;

        while (index < n * n + 1) {
            res[y][x] = index;
            if (!(0<=x + dx && x + dx < n && 0<=y + dy && y + dy < n) || res[y+dy][x+dx] != 0) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            x += dx;
            y += dy;
            index++;
        }
        return res;
    }
}
