package day20241011;

/**
 * @author by asia
 * @Classname Num701
 * @Description TODO
 * @Date 2024/10/15 14:49
 */
public class Num701 {

    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
