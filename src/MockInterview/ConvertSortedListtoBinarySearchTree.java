package MockInterview;

public class ConvertSortedListtoBinarySearchTree {


    static void main() {
        ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
        ListNode node = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        System.out.println(test.sortedListToBST(node));
    }
    ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode dummy = head;
        while (dummy != null ) {
            dummy = dummy.next;
            n++;
        }
       current = head;

        return helper(n);
    }

    public TreeNode helper(int n) {
        if (n == 0) {
            return null;
        }

        int leftSize = n / 2;
        TreeNode left = helper(leftSize);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(n - leftSize - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
