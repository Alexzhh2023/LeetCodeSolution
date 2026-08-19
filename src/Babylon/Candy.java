package Babylon;

import java.util.Arrays;

public class Candy {

    static void main() {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int [] {1,0,2}));
    }

    public int candy(int[] ratings) {
        int [] candy = new int[ratings.length];
        Arrays.fill(candy,1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }

        int res = candy[ratings.length-1];
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
            res+=candy[i];
        }

        return res;
    }
}
