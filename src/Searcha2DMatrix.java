public class Searcha2DMatrix {
    static void main() {
//        int[][]matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
//        System.out.println( searchMatrix(matrix,11));
        int[][]matrix = new int[][]{{1,1}};
        System.out.println( searchMatrix(matrix,2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid/col][mid%col]) {
                return true;
            }  else if (target > matrix[mid/col][mid%col]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
