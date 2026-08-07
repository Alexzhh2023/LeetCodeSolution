import java.util.*;

public class GroupAnagrams {
    static void main() {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String cur = String.valueOf(arr);
            if (!result.containsKey(cur)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                result.put(cur, list);
            } else  {
                result.get(cur).add(s);
            }
        }
        return new ArrayList<>(result.values());
    }
}
