package day20241111;

/**
 * @author by asia
 * @Classname Num1143
 * @Description TODO
 * @Date 2024/11/11 19:00
 */
public class Num1143 {

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";
        System.out.println(new Num1143().longestCommonSubsequence(a, b));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] f = new int[n + 1][m + 1];
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                }
            }
        }
        return f[n][m];
    }
}
