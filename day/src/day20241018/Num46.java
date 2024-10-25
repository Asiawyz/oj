package day20241018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num46
 * @Description TODO
 * @Date 2024/10/17 20:42
 */
public class Num46 {

    public static void main(String[] args) {

    }


    List<Integer> tmp;
    List<List<Integer>> ans;
    int n;
    int[] f;
    boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        f = nums;
        flag = new boolean[n];
        tmp = new ArrayList<>(n);
        ans = new LinkedList<>();
        Arrays.sort(nums);
        dfs();
        return ans;
    }

    public void dfs() {
        if (tmp.size() == n) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            tmp.add(f[i]);
            dfs();
            tmp.remove(tmp.size() - 1);
            flag[i] = false;
        }
    }
}
