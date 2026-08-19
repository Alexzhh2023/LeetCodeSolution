package Babylon;

import java.util.ArrayList;

public class swapPairs {
    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static void main() {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode res = swapPairs(head);
        ArrayList<Integer> list = new ArrayList<>();
        while (res!= null) {
            list.add(res.val);
            res = res.next;
        }
        System.out.println(list);

    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
//        Babylon.ListNode temp = head.next;
//        head.next = Babylon.swapPairs(temp.next);
//        temp.next = head;
//        return temp;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, cur = head;

        while (cur != null && cur.next != null) {
            ListNode npn = cur.next.next;
            ListNode second = cur.next;

            second.next = cur;
            cur.next = npn;
            prev.next = second;

            prev = cur;
            cur = npn;
        }

        return dummy.next;
    }






}
