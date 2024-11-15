package day20241114;

/**
 * @author by asia
 * @Classname Num647
 * @Description TODO
 * @Date 2024/11/15 1:14
 */
public class Num647 {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n + 1][n];
        int ans = n;
        for (int i = 0; i < n; i++) {
            f[1][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                f[2][i] = true;
                ++ans;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = i + j - 1;
                if (s.charAt(j) == s.charAt(k)) {
                    f[i][j] = f[i - 2][j + 1];
                    if (f[i][j]) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }

}
