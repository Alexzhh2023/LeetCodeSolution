package Babylon;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIIFormula {

    static void main() {
        PascalsTriangleIIFormula pt = new PascalsTriangleIIFormula();
        System.out.println(pt.generate(13));
    }
    public List<Integer> generate(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int)helper(rowIndex, i));
        }
        return result;
    }

    public long helper(int row, int index) {
        return factorial(row) / (factorial(index) * factorial(row - index));
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
