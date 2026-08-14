import java.util.*;

public class PascalsTriangleBaseOnPre {

    static void main() {
        PascalsTriangleBaseOnPre pt = new PascalsTriangleBaseOnPre();
        System.out.println(pt.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {

       List<List<Integer>> result = new ArrayList<>();

       for (int i = 0; i < numRows; i++) {
           List<Integer> row = new ArrayList<>();
           row.add(1);

           for (int j = 1; j < i; j ++) {
               List<Integer> pre = result.getLast();
               row.add(pre.get(j - 1) +  pre.get(j));
           }

           if (i > 0) {
               row.add(1);
           }
           result.add(row);
       }
       return result;
    }
}
