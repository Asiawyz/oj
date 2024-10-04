package tree;

public class Num226 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.right = left;
        root.left = right;
        return root;
    }
}
