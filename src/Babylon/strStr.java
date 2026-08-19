package Babylon;

public class strStr {

    static void main() {

    }

    public static int strStr(String haystack, String needle){
        int nLen = needle.length();
        if (nLen == 0) return -1;

        for (int i = 0; i <= haystack.length()-nLen; i++) {
            if (haystack.substring(i, i+nLen).equals(needle)) return i;
        }
        return -1;
    }
}
