package tree;

public class Num222 {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNums = 0, rightNums = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            ++leftNums;
            left = left.left;
        }
        while (right != null) {
            ++rightNums;
            right = right.right;
        }
        if (leftNums == rightNums) {
            return (2 << leftNums) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
