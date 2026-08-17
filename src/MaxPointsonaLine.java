import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxPointsonaLine {
    static void main() {
        int[][] points = new int[][]{
                {1,1}, {2,2}, {3,3}
        };
        MaxPointsonaLine max = new MaxPointsonaLine();
        System.out.println(max.maxPoints(points));
    }
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = i +1; j < points.length; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);
                dx = dx / g;
                dy = dy / g;
                String key = dx + "/" + dy;
                if  (map.containsKey(key)){
                    map.put(key, map.get(key) + 1);
                } else  {
                    map.put(key, 1);
                }
            }
            for (String key : map.keySet()){
                res = Math.max(res, map.get(key));
            }
        }
        return res  + 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
