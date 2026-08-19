package Babylon;

public class AddBinary {
    static void main() {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        char [] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        StringBuilder sb = new StringBuilder();

        int aIndex = aArray.length - 1, bIndex = bArray.length - 1;
        int carry = 0;
        while(aIndex >= 0 || bIndex >= 0 || carry == 1) {
            int aNum = aIndex >= 0? aArray[aIndex] - '0': 0;
            int bNum = bIndex >= 0? bArray[bIndex] - '0': 0;
            int sum = aNum + bNum + carry;
            int cur = sum % 2;
            carry = sum / 2;
            sb.append(cur);
            aIndex--;
            bIndex--;
        }
        return sb.reverse().toString();
    }
}
