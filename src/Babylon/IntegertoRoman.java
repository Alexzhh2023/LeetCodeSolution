package Babylon;

public class IntegertoRoman {
    static void main() {
        System.out.println("MMMDCCXLIX".equals(intToRoman(3749)));
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }

        return sb.toString();



//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < num/1000; i++) {
//            sb.append("M");
//        }
//
//        //handle handred
//        num = num % 1000;
//        if (num >= 900) {
//            sb.append("CM");
//        } else if (num >= 500) {
//            sb.append("D");
//            for (int j = 0; j < (num - 500)/100; j++) {
//                sb.append("C");
//            }
//        } else if (num >= 400) {
//            sb.append("CD");
//        } else if (num >= 100) {
//            for (int j = 0; j < num/400; j++) {
//                sb.append("C");
//            }
//        }
//
//        // handle d
//        num = num % 100;
//        if (num >= 90) {
//            sb.append("XC");
//        }  else if (num >= 50) {
//            sb.append("L");
//            for (int j = 0; j < (num - 50)/10; j++) {
//                sb.append("X");
//            }
//        } else if (num >= 40) {
//            sb.append("XL");
//        } else if (num >= 10) {
//            for (int j = 0; j < num/10; j++) {
//                sb.append("X");
//            }
//        }
//
//
//        //handle digit
//        num = num % 10;
//        if(num == 9){
//            sb.append("IX");
//        }
//        else if(num >= 5 && num < 9){
//            sb.append( "V");
//            for(int i = 0; i < num - 5; i++){
//               sb.append("I");
//            }
//        }
//        else if(num == 4){
//            sb.append( "IV");
//        }
//        else{
//            for(int i = 0; i < num; i++){
//                sb.append( "I");
//            }
//        }
//        return sb.toString();
    }


}
