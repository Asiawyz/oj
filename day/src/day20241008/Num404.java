package day20241008;

/**
 * @author by asia
 * @Classname Num494
 * @Description TODO
 * @Date 2024/10/8 20:29
 */
public class Num404 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Num404().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        root.val = 0;
        return dfs(root);

    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right != null) {
            root.right.val = 0;
            root.val = 0;
        }
        if (root.left != null) {
            root.val = 0;
        }
        return dfs(root.left) + dfs(root.right) + root.val;
    }
}
