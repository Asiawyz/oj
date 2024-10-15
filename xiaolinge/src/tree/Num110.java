package tree;

import java.util.HashMap;
import java.util.Map;

public class Num110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return isBalanced(root, map);
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) > -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return true;
        }
        if (Math.abs(deep(root.left, map) - deep(root.right, map)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int deep(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int count = Math.max(deep(root.left, map), deep(root.right, map)) + 1;
        map.put(root, count);
        return count;
    }
}
