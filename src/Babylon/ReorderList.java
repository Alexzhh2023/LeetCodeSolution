package Babylon;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode dummy = head;


        while(dummy!= null && pre!= null) {
            ListNode dummyTemp = dummy.next;
            ListNode preTemp = pre.next;
            dummy.next = pre;
            pre.next = dummyTemp;
            dummy = dummyTemp;
            pre = preTemp;
        }
    }
}
