package MockInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    static void main() {
        Triangle triangle = new Triangle();
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(2));
        input.add(List.of(3,4));
        input.add(List.of(6,5,7));
        input.add(List.of(4,1,8,3));

        System.out.println(triangle.minimumTotal(input));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int [] dp = new int [triangle.size()];
        for (int i = 0; i < triangle.getLast().size(); i++) {
            dp[i] = triangle.getLast().get(i);
        }

        int index = triangle.size() - 2;
        while (index >= 0) {
            for (int i = 0; i < triangle.get(index).size() ; i++) {
                dp[i] = triangle.get(index).get(i) + Math.min(dp[i + 1], dp[i]);
            }
            index--;
        }
        return dp[0];
    }
}
