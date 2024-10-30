package day20241030;

/**
 * @author by asia
 * @Classname Num70
 * @Description TODO
 * @Date 2024/10/30 10:58
 */
public class Num70 {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
