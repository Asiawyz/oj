package day20241008;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author by asia
 * @Classname Num513
 * @Description TODO
 * @Date 2024/10/15 11:03
 */
public class Num513 {

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int ans = root.val;
        while (!deque.isEmpty()) {
            int size = deque.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                ans = node.val;
            }
        }
        return ans;
    }




}
