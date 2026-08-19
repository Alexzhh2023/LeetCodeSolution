package Babylon;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static void main() {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();

        int x=0, y=0, dx =1, dy = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows * cols; i++) {
            list.add(matrix[y][x]);
            matrix[y][x] = 101;
            if (!(0<=x + dx && x + dx < cols && 0<=y + dy && y + dy < rows) || matrix[y+dy][x+dx] == 101) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            }
            x += dx;
            y += dy;
        }
        return list;
    }
}
