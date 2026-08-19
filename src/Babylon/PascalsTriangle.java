package Babylon;

import java.util.*;

public class PascalsTriangle {

    static void main() {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        result.add(Arrays.asList(1));
        int index = 0;
        while (index < numRows - 1) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            int pre = 0;
            for (int i = 0; i <= size; i++) {
                if (i ==size) {
                    row.add(pre);
                    queue.add(pre);
                } else {
                    int cur = queue.poll();
                    queue.add(cur + pre);
                    row.add(cur + pre);
                    pre = cur;
                }
            }
            result.add(row);
            index++;
        }
        return result;
    }
}
