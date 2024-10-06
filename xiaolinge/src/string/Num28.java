package string;

public class Num28 {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int[] p = new int[n];
        p[0] = -1;
        int j = -1;
        char[] chars = needle.toCharArray();
        for (int i = 1; i < n; i++) {
            while (j > -1 && chars[j + 1] != chars[i]) {
                j = p[j];
            }
            if (chars[i] == chars[j + 1]) {
                p[i] = j + 1;
                ++j;
            } else {
                p[i] = j;
            }
        }
        char[] hay = haystack.toCharArray();
        int i = -1;
        j = -1;
        int m = hay.length;
        while (i < m - 1) {
            if (hay[i + 1] == chars[j + 1]) {
                ++i;
                ++j;
                if (j == n - 1) {
                    return i - n + 1;
                }
            } else {
                if (j > -1) {
                    j = p[j];
                } else {
                    ++i;
                }
            }
        }
        return -1;
    }
}
