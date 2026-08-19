package Babylon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_BottomUp {


    static void main() {
        Triangle_BottomUp triangle = new Triangle_BottomUp();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(triangle.minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [] dp = new int [n];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        for (int row = n -2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
            }
        }
        return dp[0];
   }
}
