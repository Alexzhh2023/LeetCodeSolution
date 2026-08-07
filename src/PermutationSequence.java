import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    static void main() {
        System.out.println(getPermutation(3,1));
    }

    public static String getPermutation(int n, int k) {

        List<String> list = helper(n, new ArrayList<String>(), new StringBuilder(), new boolean[n+1]);

        return list.get(k-1);
    }

    public static List<String> helper(int n,  List<String> list, StringBuilder sb, boolean[] visited) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return list;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(i);
            helper(n,  list, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        return list;
    }
}
