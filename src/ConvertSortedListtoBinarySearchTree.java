import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {

    static void main() {
        ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
        ListNode node = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));

        TreeNode treeNode = test.sortedListToBST(node);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    public TreeNode helper(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        TreeNode left = helper(head);
        TreeNode right = helper(slow.next);
        root.left = left;
        root.right = right;
        return root;
    }

}
