package day20241009;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num106
 * @Description TODO
 * @Date 2024/10/15 11:36
 */
public class Num106 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        if (index > 0) {
            root.left = buildTree(Arrays.copyOf(inorder, index), Arrays.copyOf(postorder, index));
        }
        if (index < n - 1) {
            root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, n), Arrays.copyOfRange(postorder, index, n - 1));
        }
        return root;
    }
}
