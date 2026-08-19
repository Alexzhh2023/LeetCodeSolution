package Babylon;

public class CountandSay {
    static void main() {
        System.out.println(countAndSay(4));

    }

    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = buildNextString(res);
        }
        return res;
    }

    public static String buildNextString(String res) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i - 1) != res.charAt(i)) {
                sb.append(count).append(res.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(res.charAt(res.length() - 1));
        return sb.toString();
    }
}
