package day20241111;

import day20241108.Num309;

/**
 * @author by asia
 * @Classname Num718
 * @Description TODO
 * @Date 2024/11/11 18:26
 */
public class Num718 {

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 1};
        int[] b = {1, 0, 1, 0, 1};
        System.out.println(new Num718().findLength(a, b));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] f = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    ans = Math.max(f[i][j], ans);
                }
            }
        }
        return ans;
    }

}
