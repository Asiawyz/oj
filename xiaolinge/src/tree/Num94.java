package tree;

import java.util.ArrayList;
import java.util.List;

public class Num94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        findNode(root, ans);
        return ans;
    }

    private void findNode(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        findNode(root.left, ans);
        ans.add(root.val);
        findNode(root.right, ans);
    }
}
