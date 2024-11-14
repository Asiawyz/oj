package day20241113;

/**
 * @author by asia
 * @Classname Num115
 * @Description TODO
 * @Date 2024/11/13 13:37
 */
public class Num115 {

    public static void main(String[] args) {
//        String s = "rabbbit";
//        String t = "rabbit";
        String s = "aaaaaaaaaaaaa";
        String t = "aa";
        System.out.println(new Num115().numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        if (n < m) {
            return 0;
        }
        if (m < 1) {
            return 1;
        }
        if (s.equals(t)) {
            return 1;
        }
        int mod = 1000000000 + 7;
        int[][] f = new int[n + 1][m + 1];
        char c = t.charAt(0);
        for (int i = 1; i <= n; i++) {
            f[i][1] = f[i - 1][1];
            if (s.charAt(i - 1) == c) {
                ++f[i][1];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.min(i, m); j++) {
                f[i][j] = f[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = (f[i][j] + f[i - 1][j - 1]) % mod;
                }
            }
        }
        return f[n][m];
    }
}
