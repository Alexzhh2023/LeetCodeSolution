import java.util.*;

public class PascalsTriangleII {

    static void main() {
        PascalsTriangleII pt = new PascalsTriangleII();
        System.out.println(pt.generate(3));
    }
    public List<Integer> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> pre = result.getLast();
                row.add(pre.get(j) + pre.get(j - 1));
            }
            if (i > 0 ) {
                row.add(1);
            }
            result.add(row);
        }
        return result.getLast();
    }
}
