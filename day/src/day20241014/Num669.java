package day20241014;

/**
 * @author by asia
 * @Classname Num669
 * @Description TODO
 * @Date 2024/10/15 15:43
 */
public class Num669 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode head = new Num669().trimBST(root, 3, 4);
        System.out.println(head.val);
        if (head.left != null) {
            System.out.println(head.left.val);
        }
        if (head.right != null) {
            System.out.println(head.right.val);
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


}
