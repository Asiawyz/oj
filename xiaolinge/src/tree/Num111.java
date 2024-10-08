package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Num111 {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }

        int level = 1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return level;
    }
}
