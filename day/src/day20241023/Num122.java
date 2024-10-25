package day20241023;

/**
 * @author by asia
 * @Classname Num122
 * @Description TODO
 * @Date 2024/10/23 23:07
 */
public class Num122 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
