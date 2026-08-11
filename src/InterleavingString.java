public class InterleavingString {
    static void main() {
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        return helper (0,0);
    }

    public static boolean helper(int i, int j) {
        int index = i + j;
        return false;
    }
}
