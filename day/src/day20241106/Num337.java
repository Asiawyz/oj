package day20241106;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by asia
 * @Classname Num337
 * @Description TODO
 * @Date 2024/11/6 21:06
 */
public class Num337 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] f = dfs(root);
        return Math.max(f[0], f[1]);
    }

    /**
     * @param root  根节点
     * @return
     *          f[0] 表示可以偷 root 的情况下该子树能偷的最大值
     *          f[1] 表示不能偷 root 的情况下该子树能偷的最大值
     */
    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] f = new int[2];
        f[1] = left[0] + right[0];
        f[0] = Math.max(f[1], root.val + left[1] + right[1]);
        return f;
    }
}
