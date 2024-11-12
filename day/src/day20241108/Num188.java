package day20241108;

/**
 * @author by asia
 * @Classname Num188
 * @Description TODO
 * @Date 2024/11/8 10:41
 */
public class Num188 {

    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n][2][k + 1];
        f[0][0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int index = j * 2 - 2;
                if (i >= index) {
                    f[i][0][j] = f[i - 1][1][j - 1] - prices[i];
                    if (i - 1 >= index) {
                        f[i][0][j] = Math.max(f[i][0][j], f[i - 1][0][j]);
                    }
                }
                ++index;
                if (i >= index) {
                    f[i][1][j] = f[i - 1][0][j] + prices[i];
                    if (i - 1 >= index) {
                        f[i][1][j] = Math.max(f[i][1][j], f[i - 1][1][j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans, f[n - 1][1][i]);
        }
        return ans;
    }

}
