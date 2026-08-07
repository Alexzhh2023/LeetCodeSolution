import java.util.*;

public class InsertIntervals {
    static void main() {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {5, 8}}, new int[]{2, 6})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();

        for (int [] interval: intervals) {
            if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                merged.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
