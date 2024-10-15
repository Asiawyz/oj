package day20241015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num77
 * @Description TODO
 * @Date 2024/10/15 16:39
 */
public class Num77 {

    public static void main(String[] args) {
        new Num77().combine(5, 3);
    }

    boolean[] flag;
    List<List<Integer>> ans;
    List<Integer> tmp;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        flag = new boolean[n + 1];
        ans = new LinkedList<>();
        tmp = new ArrayList<>();
        this.n = n;
        dfs(1, k);
        return ans;
    }

    public void dfs(int left, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(tmp));
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for (int i = left; i <= n; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            tmp.add(i);
            dfs(i + 1, k - 1);
            flag[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }


}
