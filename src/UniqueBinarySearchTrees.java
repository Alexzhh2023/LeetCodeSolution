import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    static void main() {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        return helper(1, n, new HashMap<>());
    }

    public static int helper(int start, int end, Map<String, Integer> map) {
        int count = 0;
        if (start > end){
            return 1;
        }
        String key = start + "_" + end;
        if (map.containsKey(key)){
            return map.get(key);
        }

        for (int i = start; i <= end; i++){
            int right = helper(i + 1, end, map);
            int left = helper(start, i-1, map);
            count += left * right;
        }
        map.put(key, count);
        return count;
    }
}
