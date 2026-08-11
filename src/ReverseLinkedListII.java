public class ReverseLinkedListII {
    static void main() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = reverseBetween(head,2,4);
        while (res.next != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println(res.val);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode before = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;           // next: 3,4,5

            cur.next = before;                  // cur: 2
            before = cur;                       // before: 2
            cur = next;                         // cur: 3,4,5
        }

        pre.next.next = cur;
        pre.next = before;
        return dummyHead.next;
    }
}
