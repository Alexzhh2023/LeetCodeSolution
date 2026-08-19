package Babylon;

public class MaximalRectangle {
    static void main() {
        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        int [] heights = new int [matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, helper(heights));
        }
        return res;
    }

    public static int helper (int [] heights) {
        int [] left = new int [heights.length];
        int [] right = new int [heights.length];
        left[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int cur = i - 1;
            while (cur >= 0 && heights[cur] >= heights[i]) {
                cur = left[cur] - 1;
            }
            left[i] = cur + 1;
        }

        right[heights.length - 1] = heights.length - 1;

        for (int i = heights.length - 2; i >= 0; i--) {
            int cur = i + 1;
            while (cur<heights.length && heights[cur] >= heights[i]) {
                cur = right[cur] + 1;
            }
            right[i] = cur - 1;
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i] * (right[i] - left[i] + 1);
            res = Math.max(res, cur);
        }
        return res;
    }
}
