package day20241017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by asia
 * @Classname Num78
 * @Description TODO
 * @Date 2024/10/17 17:31
 */
public class Num78 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new Num78().subsets(a);
    }

    List<Integer> tmp;
    List<List<Integer>> ans;
    int n;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        tmp = new ArrayList<>(nums.length);
        n = nums.length;
        this.nums = nums;
        dfs(0);
        return ans;
    }

    public void dfs(int index) {
        if (index == n) {
            ans.add(new ArrayList<>(tmp));
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        dfs(index + 1);
        tmp.add(nums[index]);
        dfs(index + 1);
        tmp.remove(tmp.size() - 1);
    }

}
