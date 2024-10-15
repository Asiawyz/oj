package tree;

import java.util.LinkedList;
import java.util.List;

public class Num257 {

    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        String sb = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb);
            return ans;
        }
        deep(root.left, sb, ans);
        deep(root.right, sb, ans);
        return ans;
    }

    public void deep(TreeNode root, String sb, List<String> ans) {
        if (root == null) {
            return;
        }
        String str = sb + "->" + root.val;
        if (root.left == null && root.right == null) {
            ans.add(str);
            return;
        }
        deep(root.left, str, ans);
        deep(root.right, str, ans);
    }
}
