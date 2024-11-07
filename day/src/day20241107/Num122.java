package day20241107;

/**
 * @author by asia
 * @Classname Num122
 * @Description TODO
 * @Date 2024/11/7 18:25
 */
public class Num122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int x : prices) {
            if (x < min) {
                min = x;
            } else {
                ans += x - min;
                min = x;
            }
        }
        return ans;
    }

    public int maxProfit1(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i]);
        }
        return f[n - 1][1];
    }
}
