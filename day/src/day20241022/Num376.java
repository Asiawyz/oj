package day20241022;

/**
 * @author by asia
 * @Classname Num376
 * @Description TODO
 * @Date 2024/10/22 22:34
 */
public class Num376 {

    public static void main(String[] args) {
        int[] a = {0,0};
        System.out.println(new Num376().wiggleMaxLength(a));
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                up[i] = up[i - 1];
            } else {
                up[i] = Math.max(down[i - 1] + 1, up[i - 1]);
            }
            if (nums[i] >= nums[i - 1]) {
                down[i] = down[i - 1];
            } else {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
