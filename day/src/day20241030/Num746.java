package day20241030;

/**
 * @author by asia
 * @Classname Num746
 * @Description TODO
 * @Date 2024/10/30 11:00
 */
public class Num746 {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }
}
