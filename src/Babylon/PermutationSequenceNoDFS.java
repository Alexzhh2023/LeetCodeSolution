package Babylon;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceNoDFS {
    static void main() {
        System.out.println(getPermutation(3,3));
    }

    public static String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++) {
            list.add(i);
        }
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        k-=1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >0; i--) {
            int index = k/factorial;
            sb.append(list.get(index));
            list.remove(index);

            k = k % factorial;

            if (i > 1) {
                factorial /= (i - 1);
            }
        }
        return sb.toString();
    }
}
