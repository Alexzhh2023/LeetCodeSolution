import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_NoPreStored {

    static void main() {
        PascalsTriangleII_NoPreStored pt = new PascalsTriangleII_NoPreStored();
        System.out.println(pt.generate(3));
    }
    public List<Integer> generate(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
