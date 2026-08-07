public class RotateLIst {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static void main() {
        System.out.println(rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }

        for (int i = 0; i < k; i ++) {
            
        }
    }
}
