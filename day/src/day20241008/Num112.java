package day20241008;

/**
 * @author by asia
 * @Classname Num112
 * @Description TODO
 * @Date 2024/10/15 11:27
 */
public class Num112 {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val == target;
        }
        return dfs(root.left, target, sum + root.val) || dfs(root.right, target, sum + root.val);
    }
}
