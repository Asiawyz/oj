package day20241031;

/**
 * @author by asia
 * @Classname Num63
 * @Description TODO
 * @Date 2024/10/31 18:20
 */
public class Num63 {

    public static void main(String[] args) {
        int[][] a = {{0, 0}};
        System.out.println(new Num63().uniquePathsWithObstacles(a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] f = new int[n][m];
        if (obstacleGrid[0][0] != 1) {
            f[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                f[0][i] = f[0][i - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = f[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[n - 1][m - 1];
    }
}
