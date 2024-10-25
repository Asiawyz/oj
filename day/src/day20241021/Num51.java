package day20241021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num51
 * @Description TODO
 * @Date 2024/10/21 21:06
 */
public class Num51 {

    public static void main(String[] args) {
        new Num51().solveNQueens(5);
    }

    List<List<String>> ans;
    int[] f;
    boolean[] flag;
    int n;

    public List<List<String>> solveNQueens(int n) {
        ans = new LinkedList<>();
        flag = new boolean[n];
        f = new int[n];
        this.n = n;
        dfs(0);
        return ans;
    }

    public void dfs(int x) {
        if (x == n) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder s = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (k == f[j]){
                        s.append('Q');
                    }
                    else {
                        s.append('.');
                    }
                }
                tmp.add(s.toString());
            }
            for (String s : tmp) {
                System.out.println(s);
            }
            System.out.println("----------------");
            ans.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean check = true;
            if (flag[i]) {
                check = false;
            } else {
                for (int j = 0; j < x; j++) {
                    if (Math.abs(x - j) == Math.abs(f[j] - i)) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                flag[i] = true;
                f[x] = i;
                dfs(x + 1);
                flag[i] = false;
            }
        }
    }
}
