package tree;

import java.util.ArrayList;
import java.util.List;

public class Num144 {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        findNode(root, ans);
        return ans;
    }

    private void findNode(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        findNode(root.left, ans);
        findNode(root.right, ans);
    }
}
