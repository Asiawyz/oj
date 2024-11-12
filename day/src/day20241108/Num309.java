package day20241108;

/**
 * @author by asia
 * @Classname Num309
 * @Description TODO
 * @Date 2024/11/8 14:11
 */
public class Num309 {

    public static void main(String[] args) {
        int[] a = {4, 2, 7, 1, 11};
        System.out.println(new Num309().maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][4];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], Math.max(f[i - 1][2], f[i - 1][3]) - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = f[i - 1][1];
            f[i][3] = Math.max(f[i - 1][3], f[i][2]);
        }
        int ans = 0;
        for (int i = 1; i < 4; i++) {
            ans = Math.max(ans, f[n - 1][i]);
        }
        return ans;
    }
}
