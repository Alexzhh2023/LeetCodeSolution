public class ZigzagConversion {
    static void main() {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING",3)));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows[curRow].append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
