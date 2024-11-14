package day20241112;

/**
 * @author by asia
 * @Classname Num392
 * @Description TODO
 * @Date 2024/11/12 13:54
 */
public class Num392 {

    public static void main(String[] args) {
        String t = "ahbgdc";
        String s = "axc";
        System.out.println(new Num392().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int n = t.length(), m = s.length();
        if (m < 1) {
            return true;
        }
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    if (f[i][j] == m) {
                        return true;
                    }
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return false;
    }
}
