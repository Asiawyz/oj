package day20241014;

/**
 * @author by asia
 * @Classname Num108
 * @Description TODO
 * @Date 2024/10/15 16:20
 */
public class Num108 {

    public static void main(String[] args) {

    }

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    public TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);
        return root;
    }
}
