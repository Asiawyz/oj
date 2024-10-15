package tree;

import java.util.*;

public class Num236 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        dfs(root, p, set);
        List<TreeNode> list = new ArrayList<>();
        findRoot(root, q, list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = list.get(i);
            if (set.contains(treeNode)) {
                return treeNode;
            }
        }
        return null;
    }

    private boolean findRoot(TreeNode root, TreeNode q, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root == q || findRoot(root.left, q, list) || findRoot(root.right, q, list)) {
            list.add(root);
            return true;
        }
        return false;
    }

    public boolean dfs(TreeNode root, TreeNode p, Set<TreeNode> set) {
        if (root == null) {
            return false;
        }
        if (root == p || dfs(root.left, p, set) || dfs(root.right, p, set)) {
            set.add(root);
            return true;
        }
        return false;
    }

}
