package day20241104;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num518
 * @Description TODO
 * @Date 2024/11/4 21:31
 */
public class Num518 {

    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        System.out.println(new Num518().change(5, a));
    }

    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        f[0] = 1;
        for (int x : coins) {
            for (int i = x; i <= amount; i++) {
                f[i] += f[i - x];
            }
        }
        return f[amount];
    }
}
