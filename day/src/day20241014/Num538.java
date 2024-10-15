package day20241014;

/**
 * @author by asia
 * @Classname Num538
 * @Description TODO
 * @Date 2024/10/15 16:26
 */
public class Num538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        TreeNode node = new Num538().convertBST(root);
        System.out.println(node.val);
    }

    int sum;
    public TreeNode convertBST(TreeNode root) {
        this.sum = 0;
        return convert(root);
    }

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root.right);
        int tmp = root.val;
        root.val += sum;
        sum += tmp;
        convert(root.left);
        return root;
    }
}
