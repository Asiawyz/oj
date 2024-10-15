package tree;

import java.util.*;

public class Num103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new Num103().zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag = false;
        List<List<Integer>> ans = new LinkedList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            if (flag) {
                Collections.reverse(list);
            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}
