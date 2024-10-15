package day20241010;

import java.util.*;

/**
 * @author by asia
 * @Classname Num530
 * @Description TODO
 * @Date 2024/10/15 12:51
 */
public class Num530 {

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (min > list.get(i + 1) - list.get(i)) {
                min = list.get(i + 1) - list.get(i);
            }
        }
        return min;
    }
}
