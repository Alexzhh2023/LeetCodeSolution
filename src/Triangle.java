import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {


    static void main() {
        Triangle triangle = new Triangle();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(triangle.minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] memo = new int [triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return helper(triangle,0, 0,memo);
    }

   public int helper(List<List<Integer>> triangle, int row, int col,int [][] memo) {

        if (row == triangle.size()- 1) {
            return triangle.get(row).get(col);
        }

        if (memo[row][col] != Integer.MIN_VALUE) {
            return memo[row][col];
        }

        int left = helper(triangle,row + 1,col, memo);
        int right = helper(triangle,row + 1,col + 1, memo);


        return memo[row][col] = triangle.get(row).get(col)+Math.min(left,right);
   }
}
