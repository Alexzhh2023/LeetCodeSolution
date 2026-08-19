package Babylon;

public class PartitionList {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static void main() {
//        Babylon.ListNode input = new Babylon.ListNode(1, new Babylon.ListNode(4, new Babylon.ListNode(3, new Babylon.ListNode(2, new Babylon.ListNode(5, new Babylon.ListNode(2))))));
        ListNode input = new ListNode(2, new ListNode(1));
        ListNode head = partition(input,2);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small  = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else  {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeDummy.next;
        return smallDummy.next;
    }
}
