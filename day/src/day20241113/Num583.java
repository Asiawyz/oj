package day20241113;

/**
 * @author by asia
 * @Classname Num583
 * @Description TODO
 * @Date 2024/11/13 14:18
 */
public class Num583 {

    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                }
            }
        }
        return n + m - 2 * f[n][m];
    }
}
