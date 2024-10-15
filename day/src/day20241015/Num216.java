package day20241015;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num216
 * @Description TODO
 * @Date 2024/10/15 16:55
 */
public class Num216 {

    public static void main(String[] args) {
        new Num216().combinationSum3(4,1);
    }


    int n;
    boolean[] flag;
    List<List<Integer>> ans;
    List<Integer> tmp;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        ans = new LinkedList<>();
        tmp = new ArrayList<>(k);
        flag = new boolean[10];
        dfs(1, k, 0);
        return ans;
    }

    public void dfs(int left, int k, int count) {
        if (count > n) {
            return;
        }
        if (k == 0) {
            if (count == n) {
                ans.add(new ArrayList<>(tmp));
                for (int x : tmp) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = left; i <= 9; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            tmp.add(i);
            dfs(i + 1, k - 1, count + i);
            flag[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
