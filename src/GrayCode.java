import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    static void main() {
        System.out.println(grayCode(2));
    }

    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(n,list, new StringBuilder(), false);
        return list;
    }

    public static void helper(int n, List<Integer> list, StringBuilder sb, boolean reverse) {
        if (sb.length() == n) {
            list.add(Integer.parseInt(sb.toString(), 2));
            return;
        }

        if (!reverse) {
            sb.append(0);
            helper(n, list, sb, false);
            sb.deleteCharAt(sb.length()-1);

            sb.append(1);
            helper(n, list, sb, true);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(1);
            helper(n, list, sb, false);
            sb.deleteCharAt(sb.length()-1);

            sb.append(0);
            helper(n, list, sb, true);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
