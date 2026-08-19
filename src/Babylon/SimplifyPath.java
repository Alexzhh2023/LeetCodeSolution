package Babylon;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    static void main() {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }

    public static String simplifyPath(String path) {

        String [] arr = path.split("/");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (!"".equals(s)) {
                if (s.equals("..")) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    } else {
                        continue;
                    }
                } else if (s.equals(".")) {
                    continue;
                } else {
                    list.add(s);
                }
            }
        }
        if (list.size() == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("/" + list.get(i));
        }
        return sb.toString();
    }
}
