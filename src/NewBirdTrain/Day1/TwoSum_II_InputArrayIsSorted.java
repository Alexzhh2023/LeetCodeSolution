package NewBirdTrain.Day1;

import java.util.Arrays;

public class TwoSum_II_InputArrayIsSorted {
    static void main() {
        TwoSum_II_InputArrayIsSorted s = new TwoSum_II_InputArrayIsSorted();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else  {
                right--;
            }
        }
        return new int[] {};
    }
}
