package day20241105;

import day20241104.Num518;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num279
 * @Description TODO
 * @Date 2024/11/5 15:31
 */
public class Num279 {

    public static void main(String[] args) {
        System.out.println(new Num279().numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> list = new LinkedList<>();
        int x = 1;
        int y = 1;
        while (y <= n) {
            list.add(y);
            x += 1;
            y = x * x;
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, n);
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j : list) {
                if (i < j) {
                    break;
                }
                f[i] = Math.min(f[i], f[i - j] + 1);
            }
        }
        return f[n];
    }
}
