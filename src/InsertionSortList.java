public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            // Save next node before changing cur.next
            ListNode next = cur.next;

            // Find where cur should be inserted
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }

            // Insert cur between prev and prev.next
            cur.next = prev.next;
            prev.next = cur;

            // Move to next unsorted node
            cur = next;
        }

        return dummy.next;
    }
}
