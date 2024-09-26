package array;

/**
 * @author by asia
 * @Classname Num5
 * @Description Num5
 * @Date 2024/9/26 16:35
 */
public class Num5 {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        // 遍历回文串长度
        for (int i = 2; i <= len ; i++) {
            for (int j = 0; j < len; j++) {
                int k = i + j - 1;
                if (k >= len) {
                    break;
                }
                if (chars[j] != chars[k]) {
                    dp[j][k] = false;
                } else {
                    if (k - j < 3) {
                        dp[j][k] = true;
                    } else {
                        dp[j][k] = dp[j + 1][k - 1];
                    }
                }
                if (dp[j][k] && k - j + 1 > maxLen) {
                    maxLen = k - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
