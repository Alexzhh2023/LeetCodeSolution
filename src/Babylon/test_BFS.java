package Babylon;

import java.util.LinkedList;
import java.util.Queue;

public class test_BFS {
    static void main() {
        String[] arr = {"a", "b", "c"};

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.length() == arr.length) {
                System.out.println(current);
                continue;
            }

            for (String s : arr) {
                if (!current.contains(s)) {
                    queue.add(current + s);
                }
            }
        }
    }
}
