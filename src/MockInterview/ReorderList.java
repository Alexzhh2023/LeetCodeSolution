package MockInterview;

public class ReorderList {
    static void main() {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        reorderList.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (right != null) {
            ListNode tmp = right.next;
            right.next = prev;
            prev = right;
            right = tmp;
        }
        ListNode dummy = head;
        while (dummy!= null && prev != null) {
            ListNode dummyTmp = dummy.next;
            ListNode prevTmp = prev.next;
            dummy.next = prev;
            prev.next = dummyTmp;
            dummy = dummyTmp;
            prev = prevTmp;
        }

    }
}
