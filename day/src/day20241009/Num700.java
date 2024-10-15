package day20241009;

/**
 * @author by asia
 * @Classname Num700
 * @Description TODO
 * @Date 2024/10/15 12:30
 */
public class Num700 {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
