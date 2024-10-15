package day20241010;

/**
 * @author by asia
 * @Classname Num98
 * @Description TODO
 * @Date 2024/10/15 12:33
 */
public class Num98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(2147483647);

        System.out.println(new Num98().isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
