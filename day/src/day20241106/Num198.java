package day20241106;

/**
 * @author by asia
 * @Classname Num198
 * @Description TODO
 * @Date 2024/11/6 20:47
 */
public class Num198 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);
    }

}
