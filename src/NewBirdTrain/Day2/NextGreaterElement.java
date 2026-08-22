package NewBirdTrain.Day2;

import java.util.*;

public class NextGreaterElement {
    static void main() {
        NextGreaterElement next = new NextGreaterElement();
        System.out.println(Arrays.toString(next.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int cur = stack.pop();
                map.put(nums2[cur], nums2[i] );
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            map.put(nums2[cur], -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
