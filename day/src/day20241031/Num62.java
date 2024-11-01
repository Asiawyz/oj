package day20241031;

import java.util.Arrays;

/**
 * @author by asia
 * @Classname Num62
 * @Description TODO
 * @Date 2024/10/31 18:00
 */
public class Num62 {

    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        Arrays.fill(f[0], 1);
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }

}
