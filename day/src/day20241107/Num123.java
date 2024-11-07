package day20241107;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num123
 * @Description TODO
 * @Date 2024/11/7 18:33
 */
public class Num123 {

    public static void main(String[] args) {
        int[] a = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] a = {7, 6, 4, 3, 1};
//        int[] a = {1, 2, 3, 4, 5};
        System.out.println(new Num123().maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n][2][3];
        f[0][0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0][1] = Math.max(f[i - 1][0][1], -prices[i]);
            if (i > 1) {
                f[i][0][2] = f[i - 1][1][1] - prices[i];
                if (i > 2) {
                    f[i][0][2] = Math.max(f[i - 1][0][2], f[i][0][2]);
                }
            }
            f[i][1][1] = Math.max(f[i - 1][1][1], f[i - 1][0][1] + prices[i]);
            if (i > 2) {
                f[i][1][2] = f[i - 1][0][2] + prices[i];
                if (i > 3) {
                    f[i][1][2] = Math.max(f[i - 1][1][2], f[i][1][2]);
                }
            }
        }
        return Math.max(f[n - 1][1][2], Math.max(f[n - 1][1][0], f[n - 1][1][1]));
    }
}
