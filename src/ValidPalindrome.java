
public class ValidPalindrome {

    static void main() {
        ValidPalindrome p = new ValidPalindrome();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') ||  (c >= 'A' && c <= 'Z') ||  (c >= '0' && c <= '9')) {
                c = (c >= 'A' && c <= 'Z')? (char)(c+32): c;
                sb.append(c);
            }
        }

        String t =  sb.toString();
        char[] arr = t.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
