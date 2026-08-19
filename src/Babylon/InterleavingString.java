package Babylon;

public class InterleavingString {
    static void main() {
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return helper (s1,s2,s3,0,0, new Boolean[s1.length() + 1] [ s2.length() + 1]);
    }

    public static boolean helper (String s1, String s2, String s3, int i, int j, Boolean[][] visited) {
        if (i == s1.length() && j == s2.length()) {
            if ((i + j ) == s3.length()) {
                return true;
            }
            return false;
        }

        if (visited[i][j] != null) {
            return visited[i][j];
        }


        int index = i + j;

        boolean usefirst = false;
        boolean usesecond = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(index)) {
            usefirst =  helper(s1,s2,s3,i + 1, j, visited);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(index)) {
            usesecond =  helper(s1,s2,s3,i , j + 1,visited );
        }
        visited[i][j]= usefirst || usesecond;
        return usefirst || usesecond;
    }

}
