package day20241104;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num322
 * @Description TODO
 * @Date 2024/11/4 21:20
 */
public class Num322 {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int x : coins) {
                if (x > i) {
                    break;
                }
                if (f[i - x] != -1) {
                    if (f[i] == -1) {
                        f[i] = f[i - x] + 1;
                    } else {
                        f[i] = Math.min(f[i], f[i - x] + 1);
                    }
                }
            }
        }
        return f[amount];
    }
}
