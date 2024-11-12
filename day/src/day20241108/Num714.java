package day20241108;

/**
 * @author by asia
 * @Classname Num714
 * @Description TODO
 * @Date 2024/11/8 14:49
 */
public class Num714 {

    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - prices[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + prices[i] - fee);
        }
        return f[n - 1][1];
    }

}
