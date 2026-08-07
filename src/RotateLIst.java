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
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int length = 0;

        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        for (int i = 0; i < length - k % length; i++) {
            slow = slow.next;
        }

        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }
}
