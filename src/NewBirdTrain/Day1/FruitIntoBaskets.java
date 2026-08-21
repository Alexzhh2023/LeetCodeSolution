package NewBirdTrain.Day1;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    static void main() {
        FruitIntoBaskets fib = new FruitIntoBaskets();
        System.out.println(fib.totalFruit(new int [] {1,2,3,2,2}));
    }

    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            int addFruit = fruits[right];
            map.put(addFruit, map.getOrDefault(addFruit, 0) + 1);

            while (map.size() > 2) {
                int deletedFruit = fruits[left];
                map.put(deletedFruit, map.get(deletedFruit) - 1);
                if (map.get(deletedFruit) == 0) {
                    map.remove(deletedFruit);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
