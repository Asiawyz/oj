package list;

public class Num1605 {

    public static void main(String[] args) {

    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] ans = new int[n][m];
        int i = 0, j = 0;
        while (i < n) {
            int x = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = x;
            rowSum[i] -= x;
            colSum[j] -= x;
            ++j;
            if (j == m) {
                ++i;
                j = 0;
            }
        }
        return ans;
    }
}
