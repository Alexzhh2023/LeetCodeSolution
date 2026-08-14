import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {



    public Node connect(Node root) {

        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
