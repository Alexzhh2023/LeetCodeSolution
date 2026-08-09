public class ValidNumber {
    static void main() {
        System.out.println(isNumber("-1E+3"));
    }

    public static boolean isNumber(String s) {
        boolean hasE = false, hasDot = false, hasNum = false, hasNumAfterE = true;

        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                hasNum = true;
                hasNumAfterE = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasNumAfterE = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return hasNum && hasNumAfterE;
    }
}
