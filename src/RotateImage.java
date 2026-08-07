import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6},{7,8,9}};
        rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
    public static void rotate(int[][] matrix) {
        transpose(matrix, matrix.length);
        reverse(matrix, matrix.length);
    }

    public static void reverse(int[][] matrix, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            for (int i = 0; i < n; i ++) {
                swap(matrix, i,left,i, right);
            }
            left++;
            right--;
        }
    }

    public static void transpose(int[][] matrix, int n) {
        int start = 0;
        while (start < n - 1) {
            for (int i = start + 1; i < n; i++) {
                swap(matrix,start,i,i,start);
            }
            start++;
        }
    }

    public static void swap(int[][] matrix, int i, int j, int k, int m) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][m];
        matrix[k][m] = temp;
    }
}
