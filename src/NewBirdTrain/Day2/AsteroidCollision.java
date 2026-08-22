package NewBirdTrain.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    static void main() {
        AsteroidCollision obj = new AsteroidCollision();
        System.out.println(Arrays.toString(obj.asteroidCollision(new int []{5,10,-5})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean skip = false;
            while (!stack.isEmpty() && asteroids[i] < 0 && asteroids[stack.peek()] > 0){
                int prev = asteroids[stack.peek()];
                if (prev >= -asteroids[i]) {
                    if (prev == -asteroids[i]) stack.pop();
                    skip = true;
                    break;
                } else if (prev < -asteroids[i]) {
                    stack.pop();
                }
            }
            if (!skip)stack.push(i);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = asteroids[stack.pop()];
        }
        return res;
    }
}
