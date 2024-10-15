package day20241009;

/**
 * @author by asia
 * @Classname Num654
 * @Description TODO
 * @Date 2024/10/15 11:55
 */
public class Num654 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 6, 5};
        System.out.println(new Num654().constructMaximumBinaryTree(a).val);
    }

    public int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    public TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left, max = -1;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(left, index - 1);
        root.right = build(index + 1, right);
        return root;
    }
}
