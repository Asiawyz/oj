package day20241018;

import java.util.*;

/**
 * @author by asia
 * @Classname Num46
 * @Description TODO
 * @Date 2024/10/18 20:42
 */
public class Num47 {

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        new Num47().permuteUnique(a);
    }


    List<Integer> tmp;
    List<List<Integer>> ans;
    int n;
    int[] f;
    boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (flag[i] || set.contains(f[i])) {
                continue;
            }
            set.add(f[i]);
            flag[i] = true;
            tmp.add(f[i]);
            dfs();
            flag[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
