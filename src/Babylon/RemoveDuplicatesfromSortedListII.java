package Babylon;

public class RemoveDuplicatesfromSortedListII {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static void main() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode res = deleteDuplicates(head);
        while (res.next!= null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode dummyHead = cur;
        boolean isInRepeat = false;
        while (head.next != null) {
            if (head.val == head.next.val) {
                if (!isInRepeat) {
                    isInRepeat = true;
                }
                head.next = head.next.next;
            } else {
                if (isInRepeat) {
                    cur.next = head.next;
                    isInRepeat = false;
                    head = cur.next;
                } else {
                    cur = head;
                    head = head.next;
                }

            }
        }
        if (isInRepeat) {
            cur.next = null;
        }
        return dummyHead.next;
    }
}
