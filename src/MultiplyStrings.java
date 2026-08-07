public class MultiplyStrings {
    static void main() {
        System.out.println(multiply("0","0"));
    }

    public static String multiply(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        int [] res = new int[n+m];

        // generate all digit for res
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int cur = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = cur + res[p2];
                res[p1] += sum/10;
                res[p2] = sum%10;
            }
        }

        // handle res and avoid corner case
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            if ( !(sb.length() == 0 && r == 0)) {
                sb.append(r);
            }
        }
        return sb.length() == 0? "0" : sb.toString();
    }
}
