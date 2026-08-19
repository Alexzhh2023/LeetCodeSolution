package Babylon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test_ChtGPT {
    public static ArrayList<String> bfs(String[] strings) {
        ArrayList<String> resList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("");

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.length() == strings.length) {
                resList.add(current);
                continue;
            }

            // Prevent adding the same value multiple times
            // from the same BFS state
            ArrayList<String> usedAtThisLevel = new ArrayList<>();

            for (String value : strings) {
                if (usedAtThisLevel.contains(value)) {
                    continue;
                }

                if (countOccurrences(current, value)
                        < countOccurrences(strings, value)) {
                    queue.offer(current + value);
                    usedAtThisLevel.add(value);
                }
            }
        }

        return resList;
    }

    private static int countOccurrences(String current, String target) {
        int count = 0;

        for (int i = 0; i < current.length(); i++) {
            if (String.valueOf(current.charAt(i)).equals(target)) {
                count++;
            }
        }

        return count;
    }

    private static int countOccurrences(String[] strings, String target) {
        int count = 0;

        for (String value : strings) {
            if (value.equals(target)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] strings = {"word","good","best","good"};

        System.out.println(bfs(strings));
    }
}
