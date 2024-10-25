package day20241016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num131
 * @Description TODO
 * @Date 2024/10/16 23:35
 */
public class Num131 {

    public static void main(String[] args) {
        String s = "babad";


    }

    boolean[][] f;
    List<List<String>> ans;
    List<String> tmp;
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        ans = new LinkedList<>();
        tmp = new ArrayList<>();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = true;
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                int j = i + k - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    f[i][j] = false;
                } else if (j - i < 3) {
                    f[i][j] = true;
                } else {
                    f[i][j] = f[i + 1][j - 1];
                }
            }
        }

        dfs(s, 0);
        return ans;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ans.add(new ArrayList<String>(tmp));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                tmp.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
