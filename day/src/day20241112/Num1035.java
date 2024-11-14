package day20241112;

/**
 * @author by asia
 * @Classname Num1035
 * @Description TODO
 * @Date 2024/11/12 13:38
 */
public class Num1035 {

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 1, 7, 5};
        int[] b = {1, 9, 2, 5, 1};
        System.out.println(new Num1035().maxUncrossedLines(a, b));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }
}
