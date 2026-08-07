import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static void main() {
        System.out.println(Arrays.deepToString(merge(new int[][]{{4,7}, {1,4}})));
    }

    public static int[][] merge(int[][] intervals) {
        int start = 0, index = 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> merged = new ArrayList<>();
        while (index < intervals.length ) {
            if (index < intervals.length && intervals[start][1] >= intervals[index][0]) {
                intervals[start][1] = intervals[index][1] > intervals[start][1] ? intervals[index][1] : intervals[start][1];
            } else {
                merged.add(intervals[start]);
                start ++;

            }
            index++;
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
