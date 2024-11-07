package day20241107;

/**
 * @author by asia
 * @Classname Num121
 * @Description TODO
 * @Date 2024/11/7 18:07
 */
public class Num121 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] f = new int[n][2];
        f[0][0] = prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.min(prices[i], f[i - 1][0]);
            f[i][1] = Math.max(f[i - 1][1], prices[i] - f[i - 1][0]);
        }
        return f[n - 1][1];
    }

    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (max < price - min) {
                max = price - min;
            }
        }
        return max;
    }
}
